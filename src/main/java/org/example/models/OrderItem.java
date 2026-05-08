package org.example.models;

public class OrderItem {
    int id;
    int orderId;
    String itemName;
    String size;
    int price;
    int quantity;

    public OrderItem(int id, int quantity, int price, String size, String itemName, int orderId) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.size = size;
        this.itemName = itemName;
        this.orderId = orderId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
