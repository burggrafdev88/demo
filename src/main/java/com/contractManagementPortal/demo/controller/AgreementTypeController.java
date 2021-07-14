package com.contractManagementPortal.demo.controller;

import com.contractManagementPortal.demo.entities.AgreementType;
import com.contractManagementPortal.demo.entities.PaymentType;
import com.contractManagementPortal.demo.service.AgreementTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Allow requests from local host 4200
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping(value = "agreementTypes")
@RestController
public class AgreementTypeController {

    @Autowired
    AgreementTypeService agreementTypeService;

    /*Method to create a payment type.*/
    public ResponseEntity<AgreementType> createAgreementType(@RequestBody AgreementType agreementType){
        System.out.println("Create agreement type called from agreement type controller.");

        return agreementTypeService.createAgreementType(agreementType)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
}
