package com.levik.design.chat.custome.chat.persistent;

import com.levik.design.chat.custome.chat.model.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class TTLMapTest {

    private TTLMap<String, Message> map;

    @BeforeEach
    void setUp() {
        var timeMarker = new TimeMarker() {
            @Override
            public long getTime() {
                return System.currentTimeMillis();
            }
        };
        map = new TTLMap<>(2, 100, timeMarker);
    }

    @Test
    void testCase1() throws InterruptedException {
        map.put("1", new Message("123", "Hi, All", System.currentTimeMillis() - 100));
        map.put("2", new Message("234", "Yo", System.currentTimeMillis()));

        assertThat(map.size()).isEqualTo(2);

        TimeUnit.SECONDS.sleep(11);

        Message message = map.get("2");
        assertThat(message).isNull();

        map.put("2", new Message("2345", "Lol", System.currentTimeMillis()));
        assertThat(map.size()).isEqualTo(2);

    }
}