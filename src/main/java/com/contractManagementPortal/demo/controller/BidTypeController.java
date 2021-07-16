package com.contractManagementPortal.demo.controller;

import com.contractManagementPortal.demo.entities.Agreement;
import com.contractManagementPortal.demo.entities.BidType;
import com.contractManagementPortal.demo.service.BidTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Allow requests from local host 4200
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping(value = "bidtypes")
@RestController
public class BidTypeController {

    @Autowired
    private BidTypeService bidTypeService;

    //Method to create a bid type.
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<BidType> createBidType(@RequestBody BidType bidType){
        System.out.println("Create bid type called from bid type controller.");

        return bidTypeService.createBidType(bidType)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
}
