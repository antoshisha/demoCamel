package com.example.demoCamel.route;


import com.example.demoCamel.entity.InputMessage;
import com.example.demoCamel.entity.ResponseOneValue;
import com.example.demoCamel.service.RequestService;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;
import java.util.Random;

@Component
public class CounterRouter extends RouteBuilder {

    private final Random random = new Random();


    @Override
    public void configure() throws Exception {
        from("file:files/input")
                .setHeader("from", constant("FROM FILE"))
                .unmarshal().json(JsonLibrary.Jackson, InputMessage.class)
                .bean(RequestService.class, "processRequest")
                .marshal().json(JsonLibrary.Jackson, ResponseOneValue.class)
                .to("file:files/result");

        rest("/counters")
                .post()
                .route()
                .setHeader("from", constant("FROM REST"))
                .unmarshal().json(JsonLibrary.Jackson, InputMessage.class)
                .bean(RequestService.class, "processRequest")
                .marshal().json(JsonLibrary.Jackson, ResponseOneValue.class)
                .end();

        from("timer:counter-timer?period=5000")
                .setHeader("from", constant("FROM TIMER"))
                .process(exchange -> {
                        InputMessage im = new InputMessage();
                        im.setMessageType("UPDATE");
                        im.setCounterName("counter-timer");
                        im.setIncrementValue(random.nextInt(10));
                        exchange.getMessage().setBody(im);})
                .bean(RequestService.class, "processRequest")
                .marshal().json(JsonLibrary.Jackson, ResponseOneValue.class);
    }
}
