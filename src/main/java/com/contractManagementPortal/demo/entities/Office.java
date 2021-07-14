package com.contractManagementPortal.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Office {

    @Id
    @GeneratedValue
    private Long id;

    private String office;

    public Office() {
    }

    public Office(Long id, String office) {
        this.id = id;
        this.office = office;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }
}
