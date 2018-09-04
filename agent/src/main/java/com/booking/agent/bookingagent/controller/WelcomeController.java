package com.booking.agent.bookingagent.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.booking.agent.bookingagent.auth.TokenResponse;
import com.booking.agent.bookingagent.client.LodgingClient;
import com.booking.agent.bookingagent.model.Agent;
import com.booking.agent.bookingagent.model.Comment;
import com.booking.agent.bookingagent.model.GetAllResponse;
import com.booking.agent.bookingagent.model.ImageUrl;
import com.booking.agent.bookingagent.model.Lodging;
import com.booking.agent.bookingagent.model.Period;
import com.booking.agent.bookingagent.model.Reservations;
import com.booking.agent.bookingagent.service.AgentService;
import com.booking.agent.bookingagent.service.CategoryService;
import com.booking.agent.bookingagent.service.CommentService;
import com.booking.agent.bookingagent.service.ImageUriService;
import com.booking.agent.bookingagent.service.LodgingService;
import com.booking.agent.bookingagent.service.LodgingTypeService;
import com.booking.agent.bookingagent.service.MessageService;
import com.booking.agent.bookingagent.service.PeriodService;
import com.booking.agent.bookingagent.service.ReservationsService;
import com.booking.agent.bookingagent.service.ServiceService;
import com.booking.agent.bookingagent.service.UserService;
import com.booking.agent.bookingagent.util.DateUtil;

@RestController
public class WelcomeController {

	@Autowired
	private LodgingService lodgingService;
	@Autowired
	private AgentService agentService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ServiceService favourService;
	@Autowired
	private UserService userService;
	@Autowired
	private LodgingTypeService lodgingTypeService;
	@Autowired
	private ImageUriService imageUrlService;
	@Autowired
	private PeriodService periodService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private ReservationsService reservationService;
	@Autowired
	private MessageService messageService;
	@Autowired
	LodgingClient client;

	@RequestMapping(value = "/login/{agentId}", method = RequestMethod.POST)
	private TokenResponse sync(@PathVariable("agentId") String agentId, HttpServletRequest request) throws ParseException {
		GetAllResponse response = client.getAll(agentId);
		String jwtToken = "";

           
		Agent foundAgent = agentService.findByBusinessId(agentId);
        
        
        
        
		System.out.println("Agentara: " + response.getAgent().getBusinessId());
		if (foundAgent == null) {
			Agent agent = agentService.save(response.getAgent());
			request.getSession().setAttribute("loggedUser", agent);
			favourService.saveAll(response.getFavours());
			categoryService.saveAll(response.getCategories());
			lodgingTypeService.saveAll(response.getLodgingTypes());
			for (Lodging l : response.getLodging()) {
				ArrayList<ImageUrl> images = Lists.newArrayList(imageUrlService
						.saveAll(l.getImageUrls()));
				l.setImageUrls(images);
				List<Period> periods = periodService.saveAll(l.getPeriods());
				l.setPeriods(periods);
				ArrayList<Comment> comments = Lists.newArrayList(commentService
						.saveAll(l.getComments()));
				l.setComments(comments);
				l.setAgent(agent);
				Lodging lodging = lodgingService.saveOrUpdate(l);
				for(Reservations r : response.getReservations()){
					if(r.getLodging().getName().equals(lodging.getName())){
						r.setUser(null);
						r.setLodging(lodging);
						reservationService.save(r);
						break;
					}
				}
				messageService.saveAll(response.getMessages());
				
			}
			Date expirationDate = DateUtil.getDateFromNow(DateUtil.MONTH_IN_SECONDS);
	        jwtToken = Jwts.builder().setSubject(agent.getBusinessId()).setIssuedAt(new Date()).setExpiration(expirationDate)
	                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

			return new TokenResponse(jwtToken, DateUtil.MONTH_IN_SECONDS);

		} else {
			List<Lodging> lodgings = lodgingService.findByAgent(foundAgent);
			for (Lodging l : lodgings) {
				List<Comment> comments = new ArrayList<Comment>();
				for (Comment comment : response.getComments()) {
					if (comment != null) {
						if (comment.getLodging().getName().equals(l.getName())) {
							comment.setLodging(l);
							commentService.saveOrUpdate(comment);
						}

					}
				}
				for(Reservations r : response.getReservations()){
					if(r.getLodging().getName().equals(l.getName())){
						r.setUser(null);
						r.setLodging(l);
						for(Period p : l.getPeriods()){
							Date periodDateFrom =  new SimpleDateFormat("yyyy-MM-dd",Locale.US).parse(p.getDateFrom().toString());
							Date periodDateTo =  new SimpleDateFormat("yyyy-MM-dd",Locale.US).parse(p.getDateTo().toString());
							Date reservationDateFrom =  new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy",Locale.US).parse(r.getPeriod().getDateFrom().toString());
							Date reservationDateTo =  new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy",Locale.US).parse(r.getPeriod().getDateTo().toString());
							
							if(periodDateFrom.compareTo(reservationDateFrom)==0 && periodDateTo.compareTo(reservationDateTo)==0){
								r.setPeriod(p);
								reservationService.save(r);
								break;
							}
						}
						break;
					}
				}
			}
			favourService.saveAll(response.getFavours());
			categoryService.saveAll(response.getCategories());
			lodgingTypeService.saveAll(response.getLodgingTypes());
			if(response.getMessages() != null)
			messageService.saveAll(response.getMessages());
			request.getSession().setAttribute("loggedUser", foundAgent);
		}
		
		Date expirationDate = DateUtil.getDateFromNow(DateUtil.MONTH_IN_SECONDS);
        jwtToken = Jwts.builder().setSubject(foundAgent.getBusinessId()).setIssuedAt(new Date()).setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

		return new TokenResponse(jwtToken, DateUtil.MONTH_IN_SECONDS);
	    
	}

}
