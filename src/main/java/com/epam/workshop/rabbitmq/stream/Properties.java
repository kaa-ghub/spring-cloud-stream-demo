package com.epam.workshop.rabbitmq.stream;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
@Data
public class Properties {
    @Value("${application.exceptions:#{null}}")
    private Set<String> exceptions;
}
