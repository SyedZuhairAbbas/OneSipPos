package org.example.models;

import java.util.Date;

public class Order {
    int id;
    Date timestamp;
    int total;

    public Order(int id, int total, Date timestamp) {
        this.id = id;
        this.total = total;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
