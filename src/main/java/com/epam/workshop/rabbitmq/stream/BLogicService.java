package com.epam.workshop.rabbitmq.stream;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BLogicService {
    private final StreamProducer streamProducer;

    public void event(String message) {
        streamProducer.produce("Message " + message, null);
        throw new RuntimeException("Some exception");
    }

}
