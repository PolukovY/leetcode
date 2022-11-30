package com.levik.leetcode.timeBasedKeyValueStore;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TimeMapTest {

    @Test
    void testCase1() {
        TimeMap timeMap = new TimeMap();
        String foo = timeMap.get("foo", 1);
        assertThat(foo).isEmpty();
        timeMap.set("foo", "bar", 1);
        foo = timeMap.get("foo", 1);
        assertThat(foo).isEqualTo("bar");
        timeMap.set("foo", "bar1", 3);
        foo = timeMap.get("foo", 4);
        assertThat(foo).isEqualTo("bar1");
    }
}