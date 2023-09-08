package com.levik.design.chat.custome.chat;

import com.levik.design.chat.custome.chat.model.Message;
import com.levik.design.chat.custome.chat.model.Pageable;
import com.levik.design.crud.Page;

public interface ReceiveMessage {
    Message getMessage();

    Page<Message> getMessages(String room, Pageable pageable);
}
