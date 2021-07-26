package com.example.demoCamel.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private final AtomicInteger value = new AtomicInteger();

    public int updateValue(int increment) {
        return value.addAndGet(increment);
    }

    public int getValue() {
        return value.get();
    }


}
