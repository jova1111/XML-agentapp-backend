package com.booking.agent.bookingagent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.booking.agent.bookingagent.model.Category;
import com.booking.agent.bookingagent.service.CategoryService;



@RestController
public class CategoryContoller {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/categories", method = RequestMethod.GET)
	public ResponseEntity<List<Category>> getServices(){
		List<Category> categories = categoryService.findAll();
		return new ResponseEntity<List<Category>>(categories,HttpStatus.OK);
	}
}
