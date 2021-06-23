package com.epam.workshop.rabbitmq.stream;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.http.MediaType;
import org.springframework.integration.IntegrationMessageHeaderAccessor;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class StreamProducer {

    private final Processor processor;

    public void produce(String payload, String routingKey) {
        log.info("Try to produce message {} , consumer: {}", payload, routingKey);
        Message<String> message = MessageBuilder
                .withPayload(payload)
                .setHeader(MessageHeaders.REPLY_CHANNEL, routingKey)
                .setHeader(MessageHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN)
                .build();
        processor.output().send(message);
    }
}