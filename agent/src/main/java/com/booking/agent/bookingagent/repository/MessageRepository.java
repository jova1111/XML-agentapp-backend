package com.booking.agent.bookingagent.repository;


import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.booking.agent.bookingagent.model.Message;

@Repository
public interface MessageRepository extends PagingAndSortingRepository<Message, Long> {

	List<Message> getByReciverId(String reciverId);
  //  List<Message> findByReceiverIdAndReceivingUserType(Long receiverId, UserType receivingUserType);

   // List<Message> findBySenderIdAndSendingUserType(Long senderId, UserType sendingUserType);
}
