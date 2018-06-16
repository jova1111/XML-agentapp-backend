package com.booking.agent.bookingagent.service;

import java.util.List;

import com.booking.agent.bookingagent.model.Lodging;



public interface LodgingService {

    void saveOrUpdate(Lodging user);
    List<Lodging> findAll();
	void saveAll(List<Lodging> lodgings);
   

}
