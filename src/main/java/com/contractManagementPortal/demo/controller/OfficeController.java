package com.contractManagementPortal.demo.controller;

import com.contractManagementPortal.demo.entities.Office;
import com.contractManagementPortal.demo.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.contractManagementPortal.demo.service.OfficeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Allow requests from local host 4200
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping(value = "offices")
@RestController
public class OfficeController {

    @Autowired
    private OfficeRepository officeRepository;

    @Autowired
    private OfficeService officeService;

    /*Method for inserting a contractor into the db.*/
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Office> createOffice(@RequestBody Office office) {
        System.out.println("Create office called from Office controller.");

        return officeService.createOffice(office)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

}
