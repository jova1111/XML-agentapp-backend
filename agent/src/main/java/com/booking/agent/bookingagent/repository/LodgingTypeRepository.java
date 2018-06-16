package com.booking.agent.bookingagent.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.booking.agent.bookingagent.model.LodgingType;


@Repository
public interface LodgingTypeRepository extends PagingAndSortingRepository<LodgingType,Long>{
	
	List<LodgingType> findAll();

}
