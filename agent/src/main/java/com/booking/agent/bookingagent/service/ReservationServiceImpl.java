package com.booking.agent.bookingagent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.agent.bookingagent.model.Reservations;
import com.booking.agent.bookingagent.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements  ReservationsService {

	@Autowired
	ReservationRepository reservationRepository;
	@Override
	public List<Reservations> findAll() {
		// TODO Auto-generated method stub
		return reservationRepository.findAll();
	}
	@Override
	public Optional<Reservations> findById(Long id) {
		// TODO Auto-generated method stub
		return reservationRepository.findById(id);
	}
	@Override
	public void save(Reservations reservation) {
		reservationRepository.save(reservation);
		
	}

}
