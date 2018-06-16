package com.booking.agent.bookingagent.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.booking.agent.bookingagent.model.Lodging;



@Repository
public interface LodgingRepository extends PagingAndSortingRepository<Lodging, Long> {

    List<Lodging> findAll();

    }
