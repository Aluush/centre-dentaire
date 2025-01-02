package com.projet1.demo.services;

import com.projet1.demo.entities.InvoiceEntity;
import com.projet1.demo.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public List<InvoiceEntity> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    @Override
    public InvoiceEntity getInvoiceById(Long id) {
        return invoiceRepository.findById(id).orElseThrow(() -> new RuntimeException("Invoice not found"));
    }

    @Override
    public InvoiceEntity createInvoice(InvoiceEntity invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public InvoiceEntity updateInvoice(Long id, InvoiceEntity invoice) {
        InvoiceEntity existingInvoice = getInvoiceById(id);
        existingInvoice.setDate(invoice.getDate());
        existingInvoice.setAmount(invoice.getAmount());
        existingInvoice.setPaid(invoice.isPaid());
        existingInvoice.setTreatmentSheet(invoice.getTreatmentSheet());
        existingInvoice.setPayment(invoice.getPayment());
        return invoiceRepository.save(existingInvoice);
    }

    @Override
    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }
}
