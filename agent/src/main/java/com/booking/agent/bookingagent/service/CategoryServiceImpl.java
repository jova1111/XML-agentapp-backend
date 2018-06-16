package com.booking.agent.bookingagent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.agent.bookingagent.model.Category;
import com.booking.agent.bookingagent.repository.CategoryRepository;


@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}
	@Override
	public void saveAll(List<Category> categories) {
		categoryRepository.saveAll(categories);
		
	}

}
