package com.murach.model;

import jakarta.persistence.*;

@Entity
@Table(name="LineItems")
public class LineItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LineItemId")
    private int id;
    private int invoiceId;
    @ManyToOne
    @JoinColumn(name="ProductCode")
    private Product product;
    private int quantity;

    public LineItem() {
    }

    public LineItem(int id, int invoiceId, Product product, int quantity) {
        this.id = id;
        this.invoiceId = invoiceId;
        this.product = product;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
