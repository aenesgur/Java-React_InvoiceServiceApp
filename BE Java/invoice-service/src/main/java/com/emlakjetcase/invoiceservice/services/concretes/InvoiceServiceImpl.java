package com.emlakjetcase.invoiceservice.services.concretes;

import com.emlakjetcase.invoiceservice.entities.Invoice;
import com.emlakjetcase.invoiceservice.entities.User;
import com.emlakjetcase.invoiceservice.repositories.InvoiceRepository;
import com.emlakjetcase.invoiceservice.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository _invoiceRepository;

    @Autowired
    private Environment env;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        _invoiceRepository = invoiceRepository;
    }

    @Override
    public List<Invoice> GetAll() {
        return _invoiceRepository.findAll();
    }

    @Override
    public Invoice Add(Invoice invoice) {
        invoice.setStatus(setStatus(invoice.getAmount(),invoice.getUser()));
        return _invoiceRepository.save(invoice);

    }

    @Override
    public List<Invoice> GetAllByUserId(Long userId) {
        return _invoiceRepository.getInvoicesByUserId(userId);
    }

    @Override
    public Integer GetUserAmounts(Long userId) {
        return _invoiceRepository.getUserAmounts(userId);
    }

    private String setStatus(Integer amount, User user) {
        Integer creditLimit = Integer.parseInt(env.getProperty("invoice.credit-limit"));
        Integer totalAmount = GetUserAmounts(user.getId());
        if (totalAmount == null) // It may be first record
            totalAmount = 0;

        Integer differenceAmount = creditLimit  - totalAmount;
        if (differenceAmount >= amount) {
            return "APPROVED";
        } else {
            return "NOT_APPROVED";
        }
    }


}
