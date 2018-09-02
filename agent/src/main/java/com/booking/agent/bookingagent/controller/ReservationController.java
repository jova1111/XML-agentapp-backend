package com.booking.agent.bookingagent.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.booking.agent.bookingagent.model.Reservations;
import com.booking.agent.bookingagent.service.ReservationsService;

@RestController
public class ReservationController {

	
	 @Autowired
	  private ReservationsService reservationService;
	   @RequestMapping(value="/reservations", method = RequestMethod.GET)
	    private ResponseEntity<List<Reservations>> getAll() {
		  List<Reservations> reservations = reservationService.findAll();
		   return new ResponseEntity<List<Reservations>>(reservations,HttpStatus.OK);
	    }
	   
	   @RequestMapping(value="/confirm/{id}", method = RequestMethod.PUT)
	    private ResponseEntity<Reservations> save(@PathVariable("id") Long id) {
		  Optional<Reservations> optreservation = reservationService.findById(id);
		  Reservations reservation = optreservation.get();
		  reservation.setActivated(true);
		  reservationService.save(reservation);
		  return new ResponseEntity<Reservations>(reservation,HttpStatus.OK);
	    }
}
