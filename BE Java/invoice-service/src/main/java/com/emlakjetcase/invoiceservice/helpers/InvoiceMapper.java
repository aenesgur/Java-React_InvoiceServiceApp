package com.emlakjetcase.invoiceservice.helpers;

import com.emlakjetcase.invoiceservice.dto.InvoiceDto;
import com.emlakjetcase.invoiceservice.entities.Invoice;
import com.emlakjetcase.invoiceservice.entities.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InvoiceMapper {
    public Invoice MapToInvoice(InvoiceDto invoiceDto, User user) {
        Invoice invoice = new Invoice();
        invoice.setAmount(invoiceDto.getAmount());
        invoice.setBillNo(invoiceDto.getBillNo());
        invoice.setProductName(invoiceDto.getProductName());
        invoice.setUser(user);
        return invoice;
    }
    
    public List<InvoiceDto> MapToInvoiceDtoList(List<Invoice> invoices){
        List<InvoiceDto> invoiceDtoList = new ArrayList<>();


        invoices.forEach(invoice -> {
            InvoiceDto invoiceDto = new InvoiceDto();
            invoiceDto.setId(invoice.getId());
            invoiceDto.setAmount(invoice.getAmount());
            invoiceDto.setBillNo(invoice.getBillNo());
            invoiceDto.setProductName(invoice.getProductName());
            invoiceDto.setStatus(invoice.getStatus());
            invoiceDtoList.add(invoiceDto);
        });


        return invoiceDtoList;
    }
}
