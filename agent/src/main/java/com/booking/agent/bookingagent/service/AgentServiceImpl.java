package com.booking.agent.bookingagent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.agent.bookingagent.model.Agent;
import com.booking.agent.bookingagent.repository.AgentRepository;

@Service
public class AgentServiceImpl implements AgentService {

	@Autowired
	private AgentRepository agentRepository;
	
	
	@Override
	public void saveAll(List<Agent> agents) {
	agentRepository.saveAll(agents);
		
	}


	@Override
	public Agent save(Agent agent) {
	return agentRepository.save(agent);
	}


	@Override
	public Agent findByBusinessId(String string) {
		
		return agentRepository.findByBusinessId(string);
	}

}
