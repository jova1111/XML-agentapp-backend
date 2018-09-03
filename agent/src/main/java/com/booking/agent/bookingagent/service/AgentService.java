package com.booking.agent.bookingagent.service;

import java.util.List;

import com.booking.agent.bookingagent.model.Agent;

public interface AgentService {

	 

		void saveAll(List<Agent> categories);

		Agent save(Agent agent);

		Agent findByBusinessId(String string);
}
