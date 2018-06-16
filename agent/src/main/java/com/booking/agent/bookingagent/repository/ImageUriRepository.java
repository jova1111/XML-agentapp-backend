package com.booking.agent.bookingagent.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.booking.agent.bookingagent.model.ImageUrl;



@Repository
public interface ImageUriRepository extends PagingAndSortingRepository<ImageUrl,Long> {
	List<ImageUrl> findAll();
}
