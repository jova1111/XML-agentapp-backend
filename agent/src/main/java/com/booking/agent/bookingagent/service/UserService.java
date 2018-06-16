package com.booking.agent.bookingagent.service;

import java.util.List;

import com.booking.agent.bookingagent.model.User;

public interface UserService {

	 List<User> findAll();

		void saveAll(List<User> categories);
}
