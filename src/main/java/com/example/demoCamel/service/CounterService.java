package com.example.demoCamel.service;

import com.example.demoCamel.entity.Counter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CounterService {
    private final Map<String, Counter> counters = new ConcurrentHashMap<>();

    public synchronized Integer updateCounter(String name, int increment) {
        Counter counter = counters.get(name);
        if (counter == null) {
            counter = new Counter();
            counters.put(name, counter);
        }
        return counter.updateValue(increment);
    }

    public Map<String, Counter> getAllCounters() {
        return new HashMap<>(counters);
    }

}
