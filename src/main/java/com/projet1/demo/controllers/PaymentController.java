package com.projet1.demo.controllers;

import com.projet1.demo.entities.PaymentEntity;
import com.projet1.demo.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // Get all payments
    @GetMapping
    public List<PaymentEntity> getAllPayments() {
        return paymentService.getAllPayments();
    }

    // Get a payment by ID
    @GetMapping("/{id}")
    public PaymentEntity getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    // Create a new payment
    @PostMapping
    public PaymentEntity createPayment(@RequestBody PaymentEntity payment) {
        return paymentService.createPayment(payment);
    }

    // Update a payment
    @PutMapping("/{id}")
    public PaymentEntity updatePayment(@PathVariable Long id, @RequestBody PaymentEntity payment) {
        return paymentService.updatePayment(id, payment);
    }

    // Delete a payment
    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
    }
}
