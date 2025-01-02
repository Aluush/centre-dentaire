package com.projet1.demo.services;

import com.projet1.demo.entities.InvoiceEntity;

import java.util.List;

public interface InvoiceService {
    List<InvoiceEntity> getAllInvoices();
    InvoiceEntity getInvoiceById(Long id);
    InvoiceEntity createInvoice(InvoiceEntity invoice);
    InvoiceEntity updateInvoice(Long id, InvoiceEntity invoice);
    void deleteInvoice(Long id);
}
