package com.booking.agent.bookingagent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.agent.bookingagent.model.Favour;
import com.booking.agent.bookingagent.repository.ServiceRepository;



@Service
public class ServiceServiceImpl implements ServiceService {

	@Autowired
	private ServiceRepository serviceRepository;
	@Override
	public List<Favour> findAll() {
		// TODO Auto-generated method stub
		return serviceRepository.findAll();
	}
	@Override
	public void saveAll(List<Favour> favours) {
		serviceRepository.saveAll(favours);
		
	}

}
