package com.levik.design.chat.custome.chat;

import com.levik.design.chat.custome.chat.model.Message;

public class MessageSenderImpl implements MessageSender {

    @Override
    public void send(String room, Message message) {
        System.out.println("Room " + room + " message send to all users " + message);
    }
}
