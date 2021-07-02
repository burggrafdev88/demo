package com.contractManagementPortal.demo.controller;

import com.contractManagementPortal.demo.entities.PaymentType;
import com.contractManagementPortal.demo.service.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Allow requests from local host 4200
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping(value = "paymentTypes")
@RestController
public class PaymentTypeController {

    @Autowired
    PaymentTypeService paymentTypeService;

    public ResponseEntity<PaymentType> createPaymentType(@RequestBody PaymentType paymentType){
        System.out.println("Create payment type called from payment type controller.");

        return paymentTypeService.createPaymentType(paymentType)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
}
