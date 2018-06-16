package com.booking.agent.bookingagent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.agent.bookingagent.model.LodgingType;
import com.booking.agent.bookingagent.repository.LodgingTypeRepository;



@Service
public class LodgingTypeServiceImpl implements LodgingTypeService {

	@Autowired
	private LodgingTypeRepository lodgingTypeRepository;
	@Override
	public List<LodgingType> findAll() {
		// TODO Auto-generated method stub
		return lodgingTypeRepository.findAll();
	}
	@Override
	public void saveAll(List<LodgingType> lodgingTypes) {
		lodgingTypeRepository.saveAll(lodgingTypes);
		
	}

}
