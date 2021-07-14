package com.contractManagementPortal.demo.controller;

import com.contractManagementPortal.demo.entities.Agreement;
import com.contractManagementPortal.demo.entities.Contractor;
import com.contractManagementPortal.demo.service.AgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//Allow requests from local host 4200
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping(value = "agreements")
@RestController
public class AgreementController {

    @Autowired
    AgreementService agreementService;

    //Method for creating an Agreement.
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Agreement> createAgreement(@RequestBody Agreement agreement){
        System.out.println("Create agreement called from Agreement controller.");

//        if(agreementService.createAgreement(agreement)){
//            System.out.println("Agreement type test!!: " + agreement.getAgreementType());
//            return new ResponseEntity<>(agreement, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }

        return agreementService.createAgreement(agreement)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    };

    //Method for returning list of all agreements.
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Agreement>> getAgreements(){
        System.out.println("Get agreements called from Agreement controller.");
        List<Agreement> agreements = agreementService.listAllAgreements();
        return new ResponseEntity<>(agreements, HttpStatus.OK);
    }

    /*Method to delete an Agreement by it's UUID (id). Method takes in a String and converts it to a UUID and then
    executes a delete operation.*/
    @RequestMapping(method = RequestMethod.DELETE, path="/{stringID}")
    public Optional<Agreement> deleteAgreementById(@PathVariable String stringID){
        System.out.println("Delete agreement by id called from Agreement controller.");
        System.out.println("Unconverted UUID in string format: " + stringID);

        //Call method to format and convert String to a UUID.
        UUID uuid = agreementService.convertStringToUUIDFormat(stringID);
        System.out.println("Converted UUID in string format: " + uuid);

        //Delete.
        Optional<Agreement> agreement = agreementService.deleteAgreementById(uuid);
        return agreement;
    }

    /*Method for updating a contractor by it's ID.*/
    @RequestMapping(method = RequestMethod.PUT, path="/{stringID}")
    public Agreement updateAgreementById(@PathVariable String stringID, @RequestBody Agreement agreement){
        System.out.println("Update agreement by UUID called from Agreement controller.");

        Agreement agreement1 = agreementService.updateAgreementById(stringID, agreement);

        return agreement1;
    }


}
