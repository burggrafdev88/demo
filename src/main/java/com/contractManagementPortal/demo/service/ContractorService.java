package com.contractManagementPortal.demo.service;

import com.contractManagementPortal.demo.entities.Contractor;
import com.contractManagementPortal.demo.repository.ContractorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ContractorService {
    @Autowired
    private ContractorRepository contractorRepository;

   /* Service to create a new contractor. Service creates the date and id for the contractor as this is not created
    on the front end.*/
    public Boolean createContractor(Contractor contractor){
        //set UUID for unique ID as this is not created on the front end.
        contractor.setId(UUID.randomUUID());

        //set date created inside the service as the date is not created on the front end.
        Date dateCreated = new Date();
        contractor.setDateAdded(dateCreated);
        contractorRepository.save(contractor);

        //What should I be returning when we have a successful/unsuccessful save?
        return true;
    }

    //Service to return all contractors in the db - no filters or parameters.
    public List<Contractor> listAllContractors(){
        List<Contractor> contractors = (List<Contractor>) contractorRepository.findAll();
        return contractors;
    }

    //Service to return all contractors based on state specified.
    public List<Contractor> listContractorsByState(String state){
        List<Contractor> contractors = contractorRepository.findByState(state);
        return contractors;
    }

    //Service to delete contractor by id. Takes in UUID that has been converted from a String.
    public void deleteContractorById(UUID id){
        contractorRepository.deleteById(id);
    }

    /*Method below converts the string version of the UUID to a true UUID by inserting '-'s in the
    correct locations and then converting the string to a UUID.*/
    public UUID convertStringToUUIDFormat(String unconvertedString){

        //Use string builder to insert '-'s in the appropriate locations.
        StringBuilder stringBuilder = new StringBuilder(unconvertedString);
        stringBuilder.insert(8,'-');
        stringBuilder.insert(13,'-');
        stringBuilder.insert(18,'-');
        stringBuilder.insert(23,'-');

        //Convert string builder object to a String.
        String convertedStringBuilderToString = stringBuilder.toString();

        //Convert string to a UUID and then return.
        UUID uuid = UUID.fromString(convertedStringBuilderToString);
        return uuid;
    }






}
