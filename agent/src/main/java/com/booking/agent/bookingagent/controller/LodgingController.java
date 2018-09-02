package com.booking.agent.bookingagent.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
	        //.saveLodging(lodging);
	        return new ResponseEntity(HttpStatus.OK);
	    }
	    @RequestMapping(value="/lodgings", method = RequestMethod.GET)
		private ResponseEntity<List<Lodging>> getAll() {
	    	System.out.println("POGODIO");
	    	List<Lodging> lodgings = lodgingService.findAll();
	        //.saveLodging(lodging);
	        return new ResponseEntity<List<Lodging>>(lodgings,HttpStatus.OK);
	    }
	    
	    @RequestMapping(value="/lodging/{id}", method = RequestMethod.GET)
		private ResponseEntity<Optional<Lodging>> getById(@PathVariable("id") Long id) {
	    	Optional<Lodging> lodging = lodgingService.findById(id);
	    	return new ResponseEntity<Optional<Lodging>>(lodging,HttpStatus.OK);
	    }
}
