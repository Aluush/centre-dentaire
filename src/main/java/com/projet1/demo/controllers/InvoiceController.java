package com.projet1.demo.controllers;

import com.projet1.demo.entities.InvoiceEntity;
import com.projet1.demo.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    // Get all invoices
    @GetMapping
    public List<InvoiceEntity> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    // Get an invoice by ID
    @GetMapping("/{id}")
    public InvoiceEntity getInvoiceById(@PathVariable Long id) {
        return invoiceService.getInvoiceById(id);
    }

    // Create a new invoice
    @PostMapping
    public InvoiceEntity createInvoice(@RequestBody InvoiceEntity invoice) {
        return invoiceService.createInvoice(invoice);
    }

    // Update an invoice
    @PutMapping("/{id}")
    public InvoiceEntity updateInvoice(@PathVariable Long id, @RequestBody InvoiceEntity invoice) {
        return invoiceService.updateInvoice(id, invoice);
    }

    // Delete an invoice
    @DeleteMapping("/{id}")
    public void deleteInvoice(@PathVariable Long id) {
        invoiceService.deleteInvoice(id);
    }
}
