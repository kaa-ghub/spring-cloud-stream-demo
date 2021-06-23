package com.epam.workshop.rabbitmq.stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.cloud.stream.test.matcher.MessageQueueMatcher.receivesPayloadThat;

@SpringBootTest
public class RabbitTest {

    @Autowired
    private MessageCollector collector;

    @Autowired
    private Processor processor;

    @Test
    @SuppressWarnings("unchecked")
    public void testMessages() throws InterruptedException {
        Message<String> message = MessageBuilder.withPayload("test").build();

        this.processor.output().send(message);

        Message<String> received = (Message<String>) this.collector
                .forChannel(this.processor.output()).poll(10, TimeUnit.SECONDS);
        assertEquals("test", received.getPayload());
    }
}
