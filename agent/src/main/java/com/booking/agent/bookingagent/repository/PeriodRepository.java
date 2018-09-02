package com.booking.agent.bookingagent.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.booking.agent.bookingagent.model.Period;

@Repository
public interface PeriodRepository extends PagingAndSortingRepository<Period,Long> {

}
