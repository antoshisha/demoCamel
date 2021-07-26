package com.example.demoCamel.service;

import com.example.demoCamel.entity.InputMessage;
import com.example.demoCamel.entity.ResponseAllCounters;
import com.example.demoCamel.entity.ResponseOneValue;
import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class RequestService {
    private final CounterService counterService;

    public RequestService(CounterService counterService) {
        this.counterService = counterService;
    }

    public void processRequest(Exchange exchange) {
        InputMessage inMessage = (InputMessage) exchange.getIn().getBody();
        switch (inMessage.getMessageType()){
            case ("UPDATE"):
               Integer integer = counterService.updateCounter(inMessage.getCounterName(), inMessage.getIncrementValue());
               exchange.getMessage().setBody(new ResponseOneValue(integer));
               Logger logger = LoggerFactory.getLogger("com/example/demoCamel/service/RequestService.java");
               logger.info(" {}, TIME IS: {}, INCREMENT VALUE: {}",
                       exchange.getMessage().getHeader("from"),
                       LocalDateTime.now(),
                       inMessage.getIncrementValue());
               break;
            case ("GET"):
                exchange.getMessage().setBody(new ResponseAllCounters(counterService.getAllCounters()));
                break;
        }
    }

}
