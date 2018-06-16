package com.booking.agent.bookingagent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.agent.bookingagent.model.ImageUrl;
import com.booking.agent.bookingagent.repository.ImageUriRepository;


@Service
public class ImageUriServiceImpl implements ImageUriService {

	@Autowired
	private ImageUriRepository imgUriRepository;
	@Override
	public ImageUrl saveOrUpdate(ImageUrl imgUri) {
		return imgUriRepository.save(imgUri);
		
	}
	@Override
	public void saveAll(List<ImageUrl> imageUris) {
		imgUriRepository.saveAll(imageUris);
		
	}

}
