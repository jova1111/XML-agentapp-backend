package com.booking.agent.bookingagent.service;

import java.util.List;
import java.util.Optional;

import com.booking.agent.bookingagent.model.Agent;
import com.booking.agent.bookingagent.model.Lodging;



public interface LodgingService {

    Lodging saveOrUpdate(Lodging user);
    List<Lodging> findAll();
	void saveAll(List<Lodging> lodgings);
	Optional<Lodging> findById(Long id);
	List<Lodging> findByAgent(Agent foundAgent);
   

}
