package com.booking.agent.bookingagent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.booking.agent.bookingagent.model.ImageUrl;
import com.booking.agent.bookingagent.service.ImageUriService;



@RestController
public class ImageUriController {

	@Autowired
	private ImageUriService imgUriService;
	
	@RequestMapping(value="/image", method = RequestMethod.POST)
    private ResponseEntity<ImageUrl> saveImage(@RequestBody ImageUrl imgUri) {
    	System.out.println("POGODIO");
        ImageUrl savedImage=imgUriService.saveOrUpdate(imgUri);
        return new ResponseEntity<ImageUrl>(savedImage,HttpStatus.OK);
    }
	
}
