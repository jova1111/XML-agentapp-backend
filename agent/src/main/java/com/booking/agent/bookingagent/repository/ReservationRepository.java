package com.booking.agent.bookingagent.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.booking.agent.bookingagent.model.Reservations;

@Repository
public interface ReservationRepository extends PagingAndSortingRepository<Reservations,Long> {

	List<Reservations> findAll();
}
