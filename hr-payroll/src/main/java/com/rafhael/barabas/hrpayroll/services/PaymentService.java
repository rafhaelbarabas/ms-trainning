package com.rafhael.barabas.hrpayroll.services;

import com.rafhael.barabas.hrpayroll.entities.Payment;
import com.rafhael.barabas.hrpayroll.entities.Worker;
import com.rafhael.barabas.hrpayroll.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class PaymentService {

    private final WorkerRepository workerRepository;

    @Autowired
    public PaymentService(WorkerRepository workerRepository) throws EntityNotFoundException {
        this.workerRepository = workerRepository;
    }

    public Payment getPayment(Long workerId, Integer days) {
        Worker worker = workerRepository.findById(workerId)
                .orElseThrow(() -> new EntityNotFoundException("worker id " + workerId + " not found"));

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
