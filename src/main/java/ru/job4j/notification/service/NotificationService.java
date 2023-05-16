package ru.job4j.notification.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.jcip.annotations.ThreadSafe;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.job4j.notification.model.Order;
import ru.job4j.notification.model.OrderStatus;

@ThreadSafe
@Service
@Slf4j
@AllArgsConstructor
public class NotificationService {

    private final KafkaTemplate<OrderStatus, Object> kafkaTemplate;

    @KafkaListener(topics = "order_status_notification")
    public void receiveOrder(OrderStatus orderStatus) {
        log.debug(orderStatus.toString());
    }
}

