package com.rafhael.barabas.hrworker.services;

import com.rafhael.barabas.hrworker.dto.WorkerDto;
import com.rafhael.barabas.hrworker.entities.Worker;
import com.rafhael.barabas.hrworker.messages.WorkerSendMessage;
import com.rafhael.barabas.hrworker.repositories.WorkerRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class WorkerService {

    private final WorkerRepository repository;
    private final WorkerSendMessage workerSendMessage;

    public WorkerService(WorkerRepository repository, WorkerSendMessage workerSendMessage) {
        this.repository = repository;
        this.workerSendMessage = workerSendMessage;
    }

    public List<Worker> findAll() {
        return repository.findAll();
    }

    public Worker findById(Long id) {
        var worker = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("worker id " + id + " not found."));

        return worker;
    }

    public Worker save(Worker worker) {
        var workerSave = repository.save(worker);
        return sendMessage(workerSave);
    }

    private Worker sendMessage(Worker worker) {
        workerSendMessage.sendMessage(WorkerDto.createFrom(worker));
        return worker;
    }
}
