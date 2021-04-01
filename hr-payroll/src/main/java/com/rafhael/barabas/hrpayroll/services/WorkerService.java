package com.rafhael.barabas.hrpayroll.services;

import com.rafhael.barabas.hrpayroll.entities.Worker;
import com.rafhael.barabas.hrpayroll.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {
    private final WorkerRepository repository;

    @Autowired
    public WorkerService(WorkerRepository repository) {
        this.repository = repository;
    }

    public Worker save(Worker worker) {
        return repository.save(worker);
    }
}
