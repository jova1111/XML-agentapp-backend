package com.booking.agent.bookingagent.service;

import java.util.List;

import com.booking.agent.bookingagent.model.ImageUrl;

public interface ImageUriService {
	ImageUrl saveOrUpdate(ImageUrl imgUri);

	Iterable<ImageUrl> saveAll(List<ImageUrl> imageUris);
}
