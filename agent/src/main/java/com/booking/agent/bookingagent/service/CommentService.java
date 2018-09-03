package com.booking.agent.bookingagent.service;

import java.util.List;
import java.util.Optional;

import com.booking.agent.bookingagent.model.Comment;




public interface CommentService {

	void saveOrUpdate(Comment comment);
	List<Comment> findAll();
	List<Comment> findByApproved(boolean approved);
	Optional<Comment> findById(Long id);
	Iterable<Comment> saveAll(List<Comment> comments);
}
