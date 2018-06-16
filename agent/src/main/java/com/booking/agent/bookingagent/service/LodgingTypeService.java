package com.booking.agent.bookingagent.service;

import java.util.List;

import com.booking.agent.bookingagent.model.LodgingType;



public interface LodgingTypeService {
	 List<LodgingType> findAll();

	void saveAll(List<LodgingType> lodgingTypes);
}
