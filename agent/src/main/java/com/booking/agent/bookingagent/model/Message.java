package com.booking.agent.bookingagent.model;

import org.apache.catalina.User;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @XmlAttribute(name = "id")
    protected Long id;

    @XmlAttribute(name = "reservation")
    @ManyToOne
    protected Reservations reservation;

    @XmlAttribute(name = "sender_id")
    protected Long senderId;

    @XmlAttribute(name = "receiver_id")
    protected Long receiverId;

    @XmlAttribute(name = "sender_username")
    protected String senderUsername;  // username korisnika koji salje poruku agentu

    @XmlAttribute(name = "receiving_user_type")
    protected UserType receivingUserType;

    @XmlAttribute(name = "content")
    protected String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reservations getReservation() {
        return reservation;
    }

    public void setReservation(Reservations reservation) {
        this.reservation = reservation;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public String getSenderUsername() {
        return senderUsername;
    }

    public void setSenderUsername(String senderUsername) {
        this.senderUsername = senderUsername;
    }

    public UserType getReceivingUserType() {
        return receivingUserType;
    }

    public void setReceivingUserType(UserType receivingUserType) {
        this.receivingUserType = receivingUserType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

