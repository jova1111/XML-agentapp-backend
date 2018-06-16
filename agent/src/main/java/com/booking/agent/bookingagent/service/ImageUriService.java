package com.booking.agent.bookingagent.service;

import java.util.List;

import com.booking.agent.bookingagent.model.ImageUrl;

public interface ImageUriService {
	ImageUrl saveOrUpdate(ImageUrl imgUri);

	void saveAll(List<ImageUrl> imageUris);
}
