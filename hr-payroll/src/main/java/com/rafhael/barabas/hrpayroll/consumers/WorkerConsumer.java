package com.rafhael.barabas.hrpayroll.consumers;

import com.rafhael.barabas.hrpayroll.entities.Worker;
import com.rafhael.barabas.hrpayroll.services.WorkerService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class WorkerConsumer {

    private final WorkerService service;

    @Autowired
    public WorkerConsumer(WorkerService service) {
        this.service = service;
    }

    @RabbitListener(queues = {"${hr-worker.rabbitmq.queue}"})
    public void listenMessages(@Payload Worker worker){
        service.save(worker);
    }
}
