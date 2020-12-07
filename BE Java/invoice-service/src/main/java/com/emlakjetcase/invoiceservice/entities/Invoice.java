package com.emlakjetcase.invoiceservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "invoices")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Invoice implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_invoices", allocationSize = 1)
    @GeneratedValue(generator = "seq_invoices", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String productName;

    private Integer amount;

    private String billNo;

    private String status;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_invoice_id")
    private User user;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
