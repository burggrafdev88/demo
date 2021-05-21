package com.contractManagementPortal.demo.controller;

import com.contractManagementPortal.demo.contractor.Contractor;
import com.contractManagementPortal.demo.repository.ContractorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//Allow requests from local host 4200
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class ContractorController {

    @Autowired
    private ContractorRepository contractorRepository;

    /*Method to insert contractor into database.
    *Request mapping tells the request type and path.
    * ResponseEntity represents an HTTP response, including headers,body and status.
    *RequestBody tells the method what format the incoming HTTP request should be converted to.  This allows us to save
    * the contractor to the database.
    */
    @RequestMapping(method = RequestMethod.POST, path="/contractors")
    public ResponseEntity<Contractor> createContractor(@RequestBody Contractor contractor){
        Contractor newContractor = contractorRepository.save(contractor);
        return new ResponseEntity<>(newContractor, HttpStatus.OK);
    }

    /*Method to retrieve all contractors from the database.
    *Request mapping tells the request type and path.
    * ResponseEntity represents an HTTP response, including headers, body and status.
    * Whereas, ResponseBody puts the value into the body of the response. Response entity also allows us to
    * add headers and status code.*/
//    @GetMapping("/contractors/")
    @RequestMapping(method = RequestMethod.GET, path = "/contractors")
    public ResponseEntity<List<Contractor>> getContractors() {
        List<Contractor> contractors = contractorRepository.findAll();
        return new ResponseEntity<>(contractors, HttpStatus.OK);
    }

}
