package com.booking.agent.bookingagent.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.agent.bookingagent.model.Agent;
import com.booking.agent.bookingagent.model.Lodging;
import com.booking.agent.bookingagent.repository.LodgingRepository;



@Service
public class LodgingServiceImp implements LodgingService {

    @Autowired
    private LodgingRepository lodgingRepository;

    @Override
    public Lodging saveOrUpdate(Lodging lodging) {
        return lodgingRepository.save(lodging);
    }

    @Override
    public List<Lodging> findAll() {
        return lodgingRepository.findAll();
    }

	@Override
	public void saveAll(List<Lodging> lodgings) {
		lodgingRepository.saveAll(lodgings);
		
	}

	@Override
	public Optional<Lodging> findById(Long id) {
		// TODO Auto-generated method stub
		return lodgingRepository.findById(id);
	}

	@Override
	public List<Lodging> findByAgent(Agent foundAgent) {
		// TODO Auto-generated method stub
		return lodgingRepository.findByAgent(foundAgent);
	}


   
}
