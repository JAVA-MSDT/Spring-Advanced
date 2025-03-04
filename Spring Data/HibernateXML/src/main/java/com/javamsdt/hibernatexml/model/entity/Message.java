package com.javamsdt.hibernatexml.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "message_table")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private int id;

    @Column(name = "message")
    private String message;

    public Message() {
    }

    public Message(short id, String message) {
        this.id = id;
        this.message = message;
    }

    public Message(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}
