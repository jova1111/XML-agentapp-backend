package com.booking.agent.bookingagent.controller;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.booking.agent.bookingagent.client.LodgingClient;
import com.booking.agent.bookingagent.model.Message;
import com.booking.agent.bookingagent.service.MessageService;

@Controller
public class MessageController {
    @Autowired
    private MessageService messageService;
    @Autowired
	 private LodgingClient client;
    @RequestMapping(value = "/secure/messages", method = RequestMethod.GET)
	private ResponseEntity<List<Message>> getAll(HttpServletRequest request){
    	List<Message> messages = messageService.findByReciverId(request.getAttribute("businessId").toString());
    	return new ResponseEntity<List<Message>>(messages,HttpStatus.OK);
    }
    @RequestMapping(value = "/message/{id}", method = RequestMethod.POST)
	private ResponseEntity<Message> save(@RequestBody Message message, @PathVariable("id") Long id){
    	System.out.println(message.getContent());
    	Optional<Message> m = messageService.findById(id);
    	Message mess = m.get();
    	message.setReservation(mess.getReservation());
    	message.setReciverId(mess.getSenderId());
    	message.setSenderId(mess.getReciverId());
    	message.setDateSent(new Date());
    	messageService.saveOrUpdate(message);
    	client.sendMessage(message);
    	return new ResponseEntity<Message>(message,HttpStatus.OK);
    }
   }
