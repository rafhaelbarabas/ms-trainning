package com.rafhael.barabas.hrworker.api.controllers;

import com.rafhael.barabas.hrworker.entities.Worker;
import com.rafhael.barabas.hrworker.repositories.WorkerRepository;
import com.rafhael.barabas.hrworker.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerController {

    @Autowired
    private WorkerService service;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        var workers = service.findAll();
        return ResponseEntity
                .ok(workers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {
        return ResponseEntity
                .ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Worker> findById(@RequestBody Worker worker) {
        return ResponseEntity
                .ok(service.save(worker));
    }
}
