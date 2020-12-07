package com.emlakjetcase.invoiceservice.repositories;
import java.util.List;
import com.emlakjetcase.invoiceservice.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    @Query(value = "SELECT * FROM  invoices WHERE user_invoice_id = ?1",nativeQuery = true)
    List<Invoice> getInvoicesByUserId(Long userId);

    @Query(value = "SELECT sum(amount) FROM invoices WHERE user_invoice_id = ?1 and status='APPROVED'", nativeQuery = true)
    Integer getUserAmounts(Long userId);
}
