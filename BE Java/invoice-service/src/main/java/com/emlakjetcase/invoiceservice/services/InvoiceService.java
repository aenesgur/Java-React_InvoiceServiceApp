package com.emlakjetcase.invoiceservice.services;

import com.emlakjetcase.invoiceservice.dto.InvoiceDto;
import com.emlakjetcase.invoiceservice.entities.Invoice;

import java.util.List;

public interface InvoiceService {
    Invoice Add(Invoice invoice);
    List<Invoice> GetAll();
    List<Invoice> GetAllByUserId(Long userId);
    Integer GetUserAmounts(Long userId);
}
