package com.contractManagementPortal.demo.paymentType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PaymentType")
public class PaymentType {
    @Id
    @GeneratedValue
    private long id;
    private String type;

//    Why do we need a no arg constructor?
    public PaymentType() {
    }

    public PaymentType(long id, String type) {
        this.id = id;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "PaymentType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
