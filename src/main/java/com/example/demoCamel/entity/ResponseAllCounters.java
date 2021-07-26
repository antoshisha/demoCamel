package com.example.demoCamel.entity;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResponseAllCounters  {
    List<CounterView> counters;

    public ResponseAllCounters(Map<String, Counter> map) {
        this.counters = map.entrySet()
                .stream()
                .map(entry -> new CounterView(entry.getKey(), entry.getValue().getValue()))
                .collect(Collectors.toList());
    }

    public List<CounterView> getCounters() {
        return counters;
    }

    public void setCounters(List<CounterView> counters) {
        this.counters = counters;
    }
}
