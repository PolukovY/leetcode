package com.levik.design.chat.custome.chat;

import com.levik.design.chat.custome.chat.model.Message;
import com.levik.design.chat.custome.chat.model.Pageable;
import com.levik.design.crud.Page;

public class ReceiveMessageImpl implements ReceiveMessage {
    @Override
    public Message getMessage() {
        return null;
    }

    @Override
    public Page<Message> getMessages(String room, Pageable pageable) {
        return null;
    }
}
