package com.booking.agent.bookingagent.service;

import java.util.List;

import com.booking.agent.bookingagent.model.Favour;



public interface ServiceService {
	
	    List<Favour> findAll();

		void saveAll(List<Favour> favours);
}
