package com.example.demoCamel.entity;


public class CounterView {
    private String counterName;
    private int count;

    public CounterView(String counterName, int count) {
        this.counterName = counterName;
        this.count = count;
    }

    public String getCounterName() {
        return counterName;
    }

    public void setCounterName(String counterName) {
        this.counterName = counterName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
