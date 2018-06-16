package com.booking.agent.bookingagent.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.booking.agent.bookingagent.model.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User,Long>{

	
}
