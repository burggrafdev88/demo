package com.contractManagementPortal.demo.entities;

import com.contractManagementPortal.demo.entities.PaymentType;
import javax.persistence.*;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;


//Entity - Contractor will be mapped to its own table by JPA. Table name will be equal to class name.
@Entity
public class Contractor {
    @Id
    private UUID id;   //use to be of type 'long' and had annotation '@GeneratedValue'

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String zip;

    /*Contractor will have a unidirectional many to one relationship with Payment Type with Contractor being the
    owning side.*/
//    @ManyToOne
//    @JoinColumn(name="payment_type_id")
//    private PaymentType paymentType;

    @Column(nullable = false)
    private Date dateAdded;

    //Default, no args constructor
    public Contractor() {

    }

    //All args constructor, date will be generated on its own.
    public Contractor(String name, String street, String city, String state, String zip, PaymentType paymentType) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.dateAdded = new Date();
//        this.paymentType = paymentType;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

//    public PaymentType getPaymentType() {
//        return paymentType;
//    }
//
//    public void setPaymentType(PaymentType paymentType) {
//        this.paymentType = paymentType;
//    }

    @Override
    public String toString() {
        return "Contractor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", dateAdded=" + dateAdded +
                '}';
    }
}
