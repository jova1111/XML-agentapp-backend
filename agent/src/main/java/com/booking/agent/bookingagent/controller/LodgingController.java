package com.booking.agent.bookingagent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.booking.agent.bookingagent.client.LodgingClient;
import com.booking.agent.bookingagent.model.Lodging;
import com.booking.agent.bookingagent.service.LodgingService;



@RestController
public class LodgingController {

	 @Autowired
	    private LodgingService lodgingService;
	 @Autowired
	 private LodgingClient client;
	    @RequestMapping(value="/lodging", method = RequestMethod.POST)
	    private ResponseEntity register(@RequestBody Lodging lodging) {
	    	System.out.println("POGODIO");
	    	lodging.setOccupancy(false);
	    	lodging.setRating(0.0);
	        lodgingService.saveOrUpdate(lodging);
	        client.saveLodging(lodging);
	        return new ResponseEntity(HttpStatus.OK);
	    }
}
