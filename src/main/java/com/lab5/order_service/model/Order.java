package com.lab5.order_service.model;

public class Order {
    private Long id;
    private String itemName;
    private Integer quantity;
    private String status; // PENDING

    public Order() {}

    public Order(Long id, String itemName, Integer quantity, String status) {
        this.id = id; this.itemName = itemName; this.quantity = quantity; this.status = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}