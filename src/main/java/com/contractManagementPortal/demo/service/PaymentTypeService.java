package com.contractManagementPortal.demo.service;

import com.contractManagementPortal.demo.entities.PaymentType;
import com.contractManagementPortal.demo.repository.PaymentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentTypeService {

    @Autowired
    private PaymentTypeRepository paymentTypeRepository;

    /* Service to create a new contractor. Service creates the date and id for the contractor as this is not created
    on the front end.*/
    public Optional<PaymentType> createPaymentType(PaymentType paymentType) {
        //set UUID for unique ID as this is not created on the front end.
//        paymentType.setId(UUID.randomUUID());

        System.out.println("PaymentType: " + paymentType.getType());

        //If the paymentType has a type, save the record, then return it. Otherwise, return empty.
        if(!paymentType.getType().isEmpty()) {

            System.out.println("All fields filled in, save will now be executed.");
            paymentType = paymentTypeRepository.save(paymentType);
            return Optional.of(paymentType);

        } else{
            System.out.println("Not all the fields are filled in.");
            return Optional.empty();
        }
    }
}
