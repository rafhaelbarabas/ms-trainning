package com.rafhael.barabas.hrpayroll.api.controllers;

import com.rafhael.barabas.hrpayroll.entities.Payment;
import com.rafhael.barabas.hrpayroll.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId,
                                              @PathVariable Integer days) {
        return ResponseEntity.ok(service.getPayment(workerId, days));
    }
}
