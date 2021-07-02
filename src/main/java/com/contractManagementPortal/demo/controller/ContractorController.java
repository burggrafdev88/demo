package com.contractManagementPortal.demo.controller;

import com.contractManagementPortal.demo.entities.Contractor;
import com.contractManagementPortal.demo.service.ContractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//Allow requests from local host 4200
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping(value = "contractors")
@RestController
public class ContractorController {

    @Autowired
    private ContractorService contractorService;

    /*Method for inserting a contractor into the db.*/
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Contractor> createContractor(@RequestBody Contractor contractor) {
        System.out.println("Create contractors called from Contractor controller.");

        return contractorService.createContractor(contractor)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    //Method for returning list of all contractors.
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Contractor>> getContractors(){
        System.out.println("Get contractors called from Contractor controller.");
        List<Contractor> contractors = contractorService.listAllContractors();
        return new ResponseEntity<>(contractors, HttpStatus.OK);
    }

    /*Method for returning list of contractors by state passed to method. May be able to use this method later for
    "find by office" capability.*/
    @RequestMapping(method = RequestMethod.GET, path="/state/{state}")
    public ResponseEntity<List<Contractor>> getContractorsByState(@PathVariable String state){
        System.out.println("Get contractors by state called from Contractor controller.");
        List<Contractor> contractors = contractorService.listContractorsByState(state);
        return new ResponseEntity<>(contractors, HttpStatus.OK);
    }

    /*Method to delete contractor by it's UUID (id). Method takes in a String and converts it to a UUID and then
    executes a delete operation.*/
    @RequestMapping(method = RequestMethod.DELETE, path="/{stringID}")
    public ResponseEntity<Contractor> deleteContractorById(@PathVariable String stringID){
        System.out.println("Delete contractor by id called from Contractor controller.");
        System.out.println("Unconverted UUID in string format: " + stringID);

        //Call method to format and convert String to a UUID.
        UUID uuid = contractorService.convertStringToUUIDFormat(stringID);
        System.out.println("Converted UUID in string format: " + uuid);

        //Delete.
        Optional<Contractor> contractor = contractorService.deleteContractorById(uuid);
        return contractor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /*Method for updating a contractor by it's ID.*/
    @RequestMapping(method = RequestMethod.PUT, path="/{stringID}")
    public Contractor updateContractorById(@PathVariable String stringID, @RequestBody Contractor contractor){
        System.out.println("Update contractor by UUID called from Contractor controller.");

        Contractor contractor1 = contractorService.updateContractorById(stringID, contractor);

        return contractor1;
    }
}
