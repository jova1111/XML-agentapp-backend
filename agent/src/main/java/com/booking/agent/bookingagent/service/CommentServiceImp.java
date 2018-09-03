package com.booking.agent.bookingagent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.agent.bookingagent.model.Comment;
import com.booking.agent.bookingagent.repository.CommentRepository;



@Service
public class CommentServiceImp implements CommentService{

	@Autowired
	private CommentRepository commentRepository;
	
	@Override
	public List<Comment> findAll() {
		// TODO Auto-generated method stub
		return commentRepository.findAll();
	}

	@Override
	public List<Comment> findByApproved(boolean approved) {
		// TODO Auto-generated method stub
		return commentRepository.findByApproved(approved);
	}

	@Override
	public void saveOrUpdate(Comment comment) {
		// TODO Auto-generated method stub
		commentRepository.save(comment);
	}

	@Override
	public Optional<Comment> findById(Long id) {
		// TODO Auto-generated method stub
		return commentRepository.findById(id);
	}

	@Override
	public Iterable<Comment> saveAll(List<Comment> comments) {
		
		return commentRepository.saveAll(comments);		
	}

}
