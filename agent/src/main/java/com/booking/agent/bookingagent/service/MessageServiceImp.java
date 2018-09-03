package com.booking.agent.bookingagent.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.agent.bookingagent.model.Message;
import com.booking.agent.bookingagent.repository.MessageRepository;



@Service
public class MessageServiceImp implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

  /*  @Override
    public List<Message> findByReceiverIdAndReceivingUserType(Long receiverId, UserType receivingUserType) {
        return messageRepository.findByReceiverIdAndReceivingUserType(receiverId, receivingUserType);
    }

    @Override
    public List<Message> findBySenderIdAndSendingUserType(Long senderId, UserType sendingUserType) {
        return messageRepository.findBySenderIdAndSendingUserType(senderId, sendingUserType);
    }
*/
    @Override
    public Message saveOrUpdate(Message message) {
        return messageRepository.save(message);
    }

	@Override
	public void saveAll(List<Message> messages) {
		messageRepository.saveAll(messages);
		
	}

	@Override
	public List<Message> findByReciverId(String string) {
		// TODO Auto-generated method stub
		return messageRepository.getByReciverId(string);
	}

	@Override
	public Optional<Message> findById(Long id) {
		// TODO Auto-generated method stub
		return messageRepository.findById(id);
	}
}
