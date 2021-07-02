package com.contractManagementPortal.demo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
public class Agreement {

    @Id
    private UUID id;

//    @Column(nullable = false)
//    private Enum type;

    @Column(nullable = false)
    private String agreementName;

//    @Column(nullable = false)
//    private Office office;

//    @ManyToOne
////    @JoinColumn(name = "Contractor_id")
//    @Column(nullable = false)
//    private Contractor contractor;

    @Column(nullable = false)
    private String pocFirstName;

    @Column(nullable = false)
    private String pocLastName;

    @Column(nullable = false)
    private String pocPhoneNumber;

    @Column(nullable = false)
    private String pocEmail;

    @Column(nullable = false)
    private Date beginDate;

    @Column(nullable = false)
    private Date expirationDate;

//    @Column(nullable = false)
//    private BidType bidType;

    @Column(nullable = false)
    private BigDecimal amount;

    //Default, no args constructor
    public Agreement() {
    }

    public Agreement(UUID id, Enum type, /*Contractor contractor,*/ String pocFirstName, String pocLastName,
                     String pocPhoneNumber, String pocEmail, Date beginDate, Date expirationDate, BigDecimal amount) {
        this.id = id;
//        this.type = type;
//        this.contractor = contractor;
        this.pocFirstName = pocFirstName;
        this.pocLastName = pocLastName;
        this.pocPhoneNumber = pocPhoneNumber;
        this.pocEmail = pocEmail;
        this.beginDate = beginDate;
        this.expirationDate = expirationDate;
        this.amount = amount;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

//    public Enum getType() {
//        return type;
//    }
//
//    public void setType(Enum type) {
//        this.type = type;
//    }

    public String getAgreementName() {
        return agreementName;
    }

    public void setAgreementName(String agreementName) {
        this.agreementName = agreementName;
    }

    //    public Contractor getContractor() {
//        return contractor;
//    }
//
//    public void setContractor(Contractor contractor) {
//        this.contractor = contractor;
//    }

    public String getPocFirstName() {
        return pocFirstName;
    }

    public void setPocFirstName(String pocFirstName) {
        this.pocFirstName = pocFirstName;
    }

    public String getPocLastName() {
        return pocLastName;
    }

    public void setPocLastName(String pocLastName) {
        this.pocLastName = pocLastName;
    }

    public String getPocPhoneNumber() {
        return pocPhoneNumber;
    }

    public void setPocPhoneNumber(String pocPhoneNumber) {
        this.pocPhoneNumber = pocPhoneNumber;
    }

    public String getPocEmail() {
        return pocEmail;
    }

    public void setPocEmail(String pocEmail) {
        this.pocEmail = pocEmail;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
