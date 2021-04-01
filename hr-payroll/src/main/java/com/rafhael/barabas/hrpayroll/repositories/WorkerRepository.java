package com.rafhael.barabas.hrpayroll.repositories;

import com.rafhael.barabas.hrpayroll.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
