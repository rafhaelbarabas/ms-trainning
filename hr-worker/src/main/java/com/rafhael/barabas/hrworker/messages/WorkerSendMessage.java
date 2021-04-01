package com.rafhael.barabas.hrworker.messages;

import com.rafhael.barabas.hrworker.dto.WorkerDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WorkerSendMessage {

    @Value("${hr-worker.rabbitmq.exchange}")
    String exchange;

    @Value("${hr-worker.rabbitmq.routingKey}")
    String routingKey;

    public final RabbitTemplate rabbitTemplate;

    @Autowired
    public WorkerSendMessage(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(WorkerDto dto){
        rabbitTemplate.convertAndSend(exchange, routingKey, dto);
    }
}
