package com.levik.design.chat.custome.chat;

import com.levik.design.chat.custome.chat.model.Message;

public interface MessageSender {

    void send(String room, Message message);
}
