package com.example.demoCamel.entity;


import org.springframework.stereotype.Component;



public class InputMessage {
    private String messageType;
    private String counterName;
    private Integer incrementValue;

    public InputMessage() {

    }

    public InputMessage(String messageType, String counterName, Integer incrementValue) {
        this.messageType = messageType;
        this.counterName = counterName;
        this.incrementValue = incrementValue;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getCounterName() {
        return counterName;
    }

    public void setCounterName(String counterName) {
        this.counterName = counterName;
    }

    public Integer getIncrementValue() {
        return incrementValue;
    }

    public void setIncrementValue(Integer incrementValue) {
        this.incrementValue = incrementValue;
    }
}
