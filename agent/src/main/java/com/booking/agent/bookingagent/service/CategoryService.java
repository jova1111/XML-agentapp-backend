package com.booking.agent.bookingagent.service;

import java.util.List;

import com.booking.agent.bookingagent.model.Category;



public interface CategoryService {
	 List<Category> findAll();

	void saveAll(List<Category> categories);
}
