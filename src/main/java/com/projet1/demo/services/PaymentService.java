package com.projet1.demo.services;

import com.projet1.demo.entities.PaymentEntity;

import java.util.List;

public interface PaymentService {
    List<PaymentEntity> getAllPayments();
    PaymentEntity getPaymentById(Long id);
    PaymentEntity createPayment(PaymentEntity payment);
    PaymentEntity updatePayment(Long id, PaymentEntity payment);
    void deletePayment(Long id);
}
