package com.projet1.demo.services;

import com.projet1.demo.entities.PaymentEntity;
import com.projet1.demo.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<PaymentEntity> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public PaymentEntity getPaymentById(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
    }

    @Override
    public PaymentEntity createPayment(PaymentEntity payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public PaymentEntity updatePayment(Long id, PaymentEntity payment) {
        PaymentEntity existingPayment = getPaymentById(id);
        existingPayment.setAmountPaid(payment.getAmountPaid());
        existingPayment.setPaymentDate(payment.getPaymentDate());
        existingPayment.setPaymentMode(payment.getPaymentMode());
        existingPayment.setInvoice(payment.getInvoice());
        return paymentRepository.save(existingPayment);
    }

    @Override
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}
