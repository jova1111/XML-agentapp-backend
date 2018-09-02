package com.booking.agent.bookingagent.controller;

import java.util.ArrayList;
import java.util.Optional;

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
import com.booking.agent.bookingagent.model.Period;
import com.booking.agent.bookingagent.service.LodgingService;
import com.booking.agent.bookingagent.service.PeriodService;

@RestController
public class PeriodController {

	  @Autowired
	  private PeriodService periodService;
	  @Autowired
	    private LodgingService lodgingService;
	  @Autowired
		 private LodgingClient client;
	   @RequestMapping(value="/period", method = RequestMethod.POST)
	    private ResponseEntity<ArrayList<Period>> savePeriods(@RequestBody ArrayList<Period> periods) {
		   ArrayList<Period> savedPeriods = periodService.saveAll(periods);
		   return new ResponseEntity<ArrayList<Period>>(savedPeriods,HttpStatus.OK);
	    }
	   @RequestMapping(value="/reserve/{template}", method = RequestMethod.PUT)
	    private ResponseEntity reserve(@PathVariable("template") String template){
		   	Long id = Long.parseLong(template.split("_")[0]);
		   	Optional<Period> period = periodService.findById(id);
		   	Period p = period.get();
		   	p.setReserved(true);
		   	periodService.save(p);
		   	Long lodgingId = Long.parseLong(template.split("_")[1]);
		   	Optional<Lodging> lodging = lodgingService.findById(lodgingId);
		   	Lodging l = lodging.get();
		   	client.updatePeriod(p,l.getName());
		   return new ResponseEntity(HttpStatus.OK);
	    }
}
