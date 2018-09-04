package com.booking.agent.bookingagent.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.booking.agent.bookingagent.client.LodgingClient;
import com.booking.agent.bookingagent.model.Lodging;
import com.booking.agent.bookingagent.model.Reservations;
import com.booking.agent.bookingagent.service.LodgingService;
import com.booking.agent.bookingagent.service.ReservationsService;

@RestController
public class ReservationController {

	
	 @Autowired
	  private ReservationsService reservationService;
	 @Autowired
	    private LodgingService lodgingService;
	  
	 @Autowired
	 private LodgingClient client;
   
	   @RequestMapping(value="/secure/reservations", method = RequestMethod.GET)
	    private ResponseEntity<List<Reservations>> getAll(HttpServletRequest request) {
		   String businessId = request.getAttribute("businessId").toString();
		   List<Reservations> reservations = reservationService.findAll();
		   reservations = reservations.stream().filter(r -> r.getLodging().getAgent().getBusinessId().equals(businessId)).collect(Collectors.toList());
		   return new ResponseEntity<List<Reservations>>(reservations,HttpStatus.OK);
	    }
	   
	   @RequestMapping(value="/confirm/{template}", method = RequestMethod.PUT)
	    private ResponseEntity<Reservations> save(@PathVariable("template") String template) {
		  Long id = Long.parseLong(template.split("_")[0]);
		   Optional<Reservations> optreservation = reservationService.findById(id);
		  Reservations reservation = optreservation.get();
		  reservation.setActivated(true);
		  reservationService.save(reservation);
		  
		  Long lodgingId = Long.parseLong(template.split("_")[1]);
		   	Optional<Lodging> lodging = lodgingService.findById(lodgingId);
		   	Lodging l = lodging.get();
		   	
		  client.updateReservation(reservation,l.getName());
		  return new ResponseEntity<Reservations>(reservation,HttpStatus.OK);
	    }
}
