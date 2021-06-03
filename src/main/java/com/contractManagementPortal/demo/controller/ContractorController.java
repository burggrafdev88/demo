package com.contractManagementPortal.demo.controller;

import com.contractManagementPortal.demo.entities.Contractor;
import com.contractManagementPortal.demo.repository.ContractorRepository;
import com.contractManagementPortal.demo.service.ContractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

//Allow requests from local host 4200
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping(value = "contractors")
@RestController
public class ContractorController {

    @Autowired
    private ContractorService contractorService;

    //New method for inserting a contractor into the db.
    @RequestMapping(method = RequestMethod.POST, path="createContractor")
    public ResponseEntity<Contractor> createContractor(@RequestBody Contractor contractor){
        System.out.println("Create contractors called from Contractor controller.");

        //I realize the createContractor method in the contractorService will always return true...so this is "wrong".
        if (contractorService.createContractor(contractor)){
            return new ResponseEntity<>(HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //New method for returning list of all contractors.
    @RequestMapping(method = RequestMethod.GET, path="/getContractors")
    public ResponseEntity<List<Contractor>> getContractors(){
        System.out.println("Get contractors called from Contractor controller.");
        List<Contractor> contractors = contractorService.listAllContractors();
        return new ResponseEntity<>(contractors, HttpStatus.OK);
    }

    /*New method for returning list of contractors by state passed to method. May be able to use this method later for
    "find by office" capability.*/
    @RequestMapping(method = RequestMethod.GET, path="getContractorsByState")
    public ResponseEntity<List<Contractor>> getContractorsByState(String state){
        System.out.println("Get contractors by state called from Contractor controller.");
        List<Contractor> contractors = contractorService.listContractorsByState(state);
        return new ResponseEntity<>(contractors, HttpStatus.OK);
    }

    //New method to delete contractor by it's UUID (id). Method takes in a String and converts it to a UUID.
    @RequestMapping(method = RequestMethod.DELETE, path="deleteContractor/{stringID}")
    public void deleteContractorById(@PathVariable String stringID){
        System.out.println("Delete contractor by id called from Contractor service.");
        System.out.println("Unconverted UUID in string format: " + stringID);

        //Call method to format and convert String to a UUID.
        UUID uuid = contractorService.convertStringToUUIDFormat(stringID);
        System.out.println("Unconverted UUID in string format: " + uuid);

        //Delete.
        contractorService.deleteContractorById(uuid);
    }


    /*Method to insert contractor into database.
    *Request mapping tells the request type and path.
    * ResponseEntity represents an HTTP response, including headers,body and status.
    *RequestBody tells the method what format the incoming HTTP request should be converted to.  This allows us to save
    * the contractor to the database.
    */
//    @RequestMapping(method = RequestMethod.POST, path="/contractors")
//    public ResponseEntity<Contractor> createContractor(@RequestBody Contractor contractor){
//        Contractor newContractor = contractorRepository.save(contractor);
////        Contractor newContractor = new Contractor(contractor);
//
//        return new ResponseEntity<>(newContractor, HttpStatus.OK);
//    }

    /*Method to retrieve all contractors from the database.
    *Request mapping tells the request type and path.
    * ResponseEntity represents an HTTP response, including headers, body and status.
    * Whereas, ResponseBody puts the value into the body of the response. Response entity also allows us to
    * add headers and status code.*/
//    @GetMapping("/contractors/")
//    @RequestMapping(method = RequestMethod.GET, path = "/contractors")
//    public ResponseEntity<List<Contractor>> getContractors() {
//        System.out.println("Get contractors called.  Will return a list.");
//        List<Contractor> contractors = contractorRepository.findAll();
//        return new ResponseEntity<>(contractors, HttpStatus.OK);
//    }

//    @DeleteMapping("/delete-contractor/{id}")
//    public void deleteContractorByID(@PathVariable String id){
//        System.out.println("ID to delete: " + id);
//        long convertedID = Long.parseLong(id);
//        contractorRepository.deleteById(convertedID);
//    }
}
