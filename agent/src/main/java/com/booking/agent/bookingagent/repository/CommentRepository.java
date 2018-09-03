package com.booking.agent.bookingagent.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.booking.agent.bookingagent.model.Comment;



@Repository
public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {

	List<Comment> findAll();
	List<Comment> findByApproved(boolean approved);
	Optional<Comment> findById(Long id);
}
