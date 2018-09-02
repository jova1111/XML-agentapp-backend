package com.booking.agent.bookingagent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.booking.agent.bookingagent.client.LodgingClient;
import com.booking.agent.bookingagent.model.GetLodgingResponse;
import com.booking.agent.bookingagent.service.AgentService;
import com.booking.agent.bookingagent.service.CategoryService;
import com.booking.agent.bookingagent.service.ImageUriService;
import com.booking.agent.bookingagent.service.LodgingService;
import com.booking.agent.bookingagent.service.LodgingTypeService;
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
	LodgingClient client;
	  /*@RequestMapping(value="/welcome", method = RequestMethod.POST)
	    private ResponseEntity sync() {
		  	System.out.println("AJDE DE AZURIRAJ");
		  	GetLodgingResponse response = new GetLodgingResponse();
	    	
	    	response = client.getLodging("Daj svega");
	    	
	    	imageUrlService.saveAll(response.getImageUris());
	    	lodgingTypeService.saveAll(response.getLodgingTypes());
	    	favourService.saveAll(response.getFavours());
	    	categoryService.saveAll(response.getCategories());
	    	userService.saveAll(response.getUsers());
	    	agentService.saveAll(response.getAgents());
	    	lodgingService.saveAll(response.getLodgings());
	        return new ResponseEntity(HttpStatus.OK);
	    */
	  
}
