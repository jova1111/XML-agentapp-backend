package com.booking.agent.bookingagent.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.booking.agent.bookingagent.model.Agent;

@Repository
public interface AgentRepository extends PagingAndSortingRepository<Agent,Long>{

	Agent findByBusinessId(String string);

}
