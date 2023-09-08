package com.levik.design.cache;

import com.levik.design.cache.model.Message;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.concurrent.TimeUnit;

class CircularArrayListTest {

    @Test
    void testCase1() throws InterruptedException {
        CircularList<Message> circularArrayList = new CircularArrayList<>(2, 2);

        circularArrayList.add(new Message("user1", "Hi All", new Date().getTime()));
        circularArrayList.add(new Message("user2", "Hi User1",  new Date().getTime() + 1 * 60 * 1000));
        circularArrayList.add(new Message("user3", "Hi User1 and User2",  new Date().getTime() + 1 * 60 * 1000));

        System.out.println(circularArrayList);

        //TimeUnit.MINUTES.sleep(1);

        //System.out.println(circularArrayList);
    }
}