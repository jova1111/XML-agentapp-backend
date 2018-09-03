package com.booking.agent.bookingagent.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

	@RequestMapping(value = "/login/{agentId}", method = RequestMethod.GET)
	private ResponseEntity sync(@PathVariable("agentId") String agentId, HttpServletRequest request) {
		GetAllResponse response = client.getAll(agentId);
		System.out.println("Agentara: " + response.getAgent().getBusinessId());
		Agent foundAgent = agentService.findByBusinessId(agentId);
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
						r.setLodging(l);
						reservationService.save(r);
						break;
					}
				}
			}
			favourService.saveAll(response.getFavours());
			categoryService.saveAll(response.getCategories());
			lodgingTypeService.saveAll(response.getLodgingTypes());
			messageService.saveAll(response.getMessages());
			request.getSession().setAttribute("loggedUser", foundAgent);
		}
		
		return new ResponseEntity(HttpStatus.OK);
	}

}
