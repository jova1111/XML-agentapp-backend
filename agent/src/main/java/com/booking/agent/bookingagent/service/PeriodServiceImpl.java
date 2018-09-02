package com.booking.agent.bookingagent.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.agent.bookingagent.model.Period;
import com.booking.agent.bookingagent.repository.PeriodRepository;
@Service
public class PeriodServiceImpl implements PeriodService {

	@Autowired
	private PeriodRepository periodRepository;
	@Override
	public ArrayList<Period> saveAll(List<Period> periods) {
		// TODO Auto-generated method stub
		Iterable<Period> period = periodRepository.saveAll(periods);
		return Lists.newArrayList(period);
	}
	@Override
	public Optional<Period> findById(Long id) {
		// TODO Auto-generated method stub
		return periodRepository.findById(id);
	}
	@Override
	public void save(Period period) {
		periodRepository.save(period);
		
	}

}
