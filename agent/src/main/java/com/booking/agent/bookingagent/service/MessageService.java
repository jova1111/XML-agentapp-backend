package com.booking.agent.bookingagent.service;



import java.util.List;
import java.util.Optional;

import com.booking.agent.bookingagent.model.Message;

public interface MessageService {
   // List<Message> findByReceiverIdAndReceivingUserType(Long receiverId, UserType receivingUserType);
   // List<Message> findBySenderIdAndSendingUserType(Long senderId, UserType sendingUserType);
    Message saveOrUpdate(Message message);

	void saveAll(List<Message> messages);

	List<Message> findByReciverId(String string);

	Optional<Message> findById(Long id);
}
