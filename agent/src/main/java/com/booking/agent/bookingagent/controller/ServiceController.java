package com.booking.agent.bookingagent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.booking.agent.bookingagent.model.Favour;
import com.booking.agent.bookingagent.service.ServiceService;



@RestController
public class ServiceController {

	@Autowired
	private ServiceService servicesService; 
	@RequestMapping(value="/service", method = RequestMethod.GET)
	public ResponseEntity<List<Favour>> getServices(){
		List<Favour> services = servicesService.findAll();
		return new ResponseEntity<List<Favour>>(services,HttpStatus.OK);
	}
}
