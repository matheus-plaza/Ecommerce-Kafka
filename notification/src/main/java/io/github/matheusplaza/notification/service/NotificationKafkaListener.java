package io.github.matheusplaza.notification.service;

import io.github.matheusplaza.notification.message.NotificationMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NotificationKafkaListener {

    @KafkaListener(topics = "${kafka.topic}")
    public void listener(NotificationMessage message) {
        log.info("Received message: {}", message);
    }
}
