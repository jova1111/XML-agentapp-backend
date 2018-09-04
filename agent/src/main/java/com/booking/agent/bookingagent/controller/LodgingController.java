package com.booking.agent.bookingagent.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.booking.agent.bookingagent.client.LodgingClient;
import com.booking.agent.bookingagent.model.Agent;
import com.booking.agent.bookingagent.model.Lodging;
import com.booking.agent.bookingagent.service.AgentService;
import com.booking.agent.bookingagent.service.LodgingService;



@RestController
public class LodgingController {

	 @Autowired
	    private LodgingService lodgingService;
	 @Autowired
	 	private AgentService agentService;
	 @Autowired
	 private LodgingClient client;
	    @RequestMapping(value="/secure/lodging", method = RequestMethod.POST)
	    private ResponseEntity register(@RequestBody Lodging lodging,HttpServletRequest request) {
	    	System.out.println("POGODIO");
	    	lodging.setOccupancy(false);
	    	lodging.setRating(0.0);
	    	String businessId = request.getAttribute("businessId").toString();
	    	System.out.println("ID: " + businessId);
	    	Agent agent = agentService.findByBusinessId(businessId);
	    	lodging.setAgent(agent);
	        lodgingService.saveOrUpdate(lodging);
	        client.saveLodging(lodging);
	        return new ResponseEntity(HttpStatus.OK);
	    }
	    @RequestMapping(value="/secure/lodgings", method = RequestMethod.GET)
		private ResponseEntity<List<Lodging>> getAll(HttpServletRequest request) {
	    	System.out.println("POGODIO");
	    	String businessId = request.getAttribute("businessId").toString();
	    	
	    	Agent agent = agentService.findByBusinessId(businessId);
	    	List<Lodging> lodgings = lodgingService.findByAgent(agent);
	        System.out.println(request.getSession().getAttribute("loggedUser"));
	        return new ResponseEntity<List<Lodging>>(lodgings,HttpStatus.OK);
	    }
	    
	    @RequestMapping(value="/lodging/{id}", method = RequestMethod.GET)
		private ResponseEntity<Optional<Lodging>> getById(@PathVariable("id") Long id) {
	    	Optional<Lodging> lodging = lodgingService.findById(id);
	    	return new ResponseEntity<Optional<Lodging>>(lodging,HttpStatus.OK);
	    }
}
