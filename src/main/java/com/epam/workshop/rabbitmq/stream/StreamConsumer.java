package com.epam.workshop.rabbitmq.stream;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StreamConsumer {

    private final BLogicService bLogicService;

    @StreamListener(Processor.INPUT)
    public void message(String message) {
        bLogicService.event(message);
    }
}
