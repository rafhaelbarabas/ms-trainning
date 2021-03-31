package com.rafhael.barabas.hrworker.api.controllers;

import com.rafhael.barabas.hrworker.entities.Worker;
import com.rafhael.barabas.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerController {

    @Autowired
    private WorkerRepository repository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        var workers = repository.findAll();
        return ResponseEntity
                .ok(workers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {
        return ResponseEntity
                .ok(repository.findById(id).get());
    }

    @PostMapping
    public ResponseEntity<Worker> findById(@RequestBody Worker worker) {
        return ResponseEntity
                .ok(repository.save(worker));
    }
}
