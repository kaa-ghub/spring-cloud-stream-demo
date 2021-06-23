package com.epam.workshop.rabbitmq.stream;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.ImmediateAcknowledgeAmqpException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsumerService {
    private final StreamProducer streamProducer;
    private final Properties properties;

    public void event(String message) {
        if ("exception".equals(message)) {
            throw new RuntimeException("Exception with message :" + message);
        } else if (properties.getExceptions().contains(message)) {
            throw new ImmediateAcknowledgeAmqpException("UnmarshallingError with message:" + message);
        }

        streamProducer.produce("Message " + message, null);
    }

}
