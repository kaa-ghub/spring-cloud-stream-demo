package com.epam.workshop.rabbitmq.stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
}
