package com.booking.agent.bookingagent.service;

import java.util.List;
import java.util.Optional;

import com.booking.agent.bookingagent.model.Reservations;

public interface ReservationsService {
	List<Reservations> findAll();

	Optional<Reservations> findById(Long id);

	void save(Reservations reservation);
}
