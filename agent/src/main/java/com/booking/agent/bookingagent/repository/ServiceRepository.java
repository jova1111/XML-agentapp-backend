package com.booking.agent.bookingagent.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.booking.agent.bookingagent.model.Favour;


@Repository
public interface ServiceRepository extends PagingAndSortingRepository<Favour,Long>{

	List<Favour> findAll();
}
