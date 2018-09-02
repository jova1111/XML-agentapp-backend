package com.booking.agent.bookingagent.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.booking.agent.bookingagent.model.Period;

public interface PeriodService {
	ArrayList<Period> saveAll(List<Period> periods);

	Optional<Period> findById(Long id);

	void save(Period period);
}
