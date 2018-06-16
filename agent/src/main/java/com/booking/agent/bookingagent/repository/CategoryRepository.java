package com.booking.agent.bookingagent.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.booking.agent.bookingagent.model.Category;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category,Long> {
	
	List<Category> findAll();

}
