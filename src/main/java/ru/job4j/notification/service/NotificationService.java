package ru.job4j.notification.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.jcip.annotations.ThreadSafe;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.job4j.notification.model.OrderStatus;

@ThreadSafe
@Service
@Slf4j
@AllArgsConstructor
public class NotificationService {

    @KafkaListener(topics = "notification")
    public void receiveOrder(OrderStatus orderStatus) {
        log.debug(orderStatus.toString());
    }
}

