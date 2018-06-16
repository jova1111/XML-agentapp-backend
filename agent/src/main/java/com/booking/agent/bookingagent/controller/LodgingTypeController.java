package com.booking.agent.bookingagent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.booking.agent.bookingagent.model.LodgingType;
import com.booking.agent.bookingagent.service.LodgingTypeService;



@RestController
public class LodgingTypeController {

	@Autowired
	private LodgingTypeService lodgingTypeService; 
	@RequestMapping(value="/types", method = RequestMethod.GET)
	public ResponseEntity<List<LodgingType>> getTypes(){
		List<LodgingType> types = lodgingTypeService.findAll();
		return new ResponseEntity<List<LodgingType>>(types,HttpStatus.OK);
	}
}
