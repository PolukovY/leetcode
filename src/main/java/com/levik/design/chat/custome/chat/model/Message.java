package com.levik.design.chat.custome.chat.model;

import com.levik.design.chat.custome.chat.persistent.TimeMarker;

public record Message(String userId, String message, long createAt) implements TimeMarker {

    @Override
    public long getTime() {
        return createAt;
    }
}
