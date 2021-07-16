package com.contractManagementPortal.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BidType")
public class BidType {

    @Id
    @GeneratedValue
    private Long id;

    private String type;

//    Why do we need a no arg constructor?
    public BidType(){

    }

    public BidType(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return "BidType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
