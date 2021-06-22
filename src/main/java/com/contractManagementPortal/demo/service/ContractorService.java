package com.contractManagementPortal.demo.service;

import com.contractManagementPortal.demo.entities.Contractor;
import com.contractManagementPortal.demo.repository.ContractorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.*;

@Service
public class ContractorService {
    @Autowired
    private ContractorRepository contractorRepository;

   /* Service to create a new contractor. Service creates the date and id for the contractor as this is not created
    on the front end.*/
    public Boolean createContractor(Contractor contractor) {
        //set UUID for unique ID as this is not created on the front end.
        contractor.setId(UUID.randomUUID());

        System.out.println("Contractor name: " + contractor.getName());

        //set date created inside the service as the date is not created on the front end.
        Date dateCreated = new Date();
        contractor.setDateAdded(dateCreated);

        if(!contractor.getName().isEmpty() && !contractor.getStreet().isEmpty() && !contractor.getCity().isEmpty() &&
                !contractor.getState().isEmpty() && !contractor.getZip().isEmpty() &&
                contractor.getDateAdded() != null) {

            System.out.println("All fields filled in, save will now be executed.");
            contractorRepository.save(contractor);
            return true;

        } else{
            System.out.println("Not all the fields are filled in.");
            return false;
        }
    }

    /*Service to return all contractors in the db.  If no contractors are found, an Entity not found
     Exception is thrown.*/
    public List<Contractor> listAllContractors(){
        List<Contractor> contractors = (List<Contractor>) contractorRepository.findAll();

        if(!contractors.isEmpty()){
            System.out.print("Contractor list is empty!");
            return contractors;
        } else{
            throw new EntityNotFoundException("No contractors were found in the database.");
        }
    }

    /*Service to return all contractors based on state specified.  If no contractors are found for the state specified,
    an Entity not found Exception is thrown.*/
    public List<Contractor> listContractorsByState(String state){
        List<Contractor> contractors = contractorRepository.findByState(state);

        if(!contractors.isEmpty()){
            System.out.print("Contractor list is empty!");
            return contractors;
        } else{
            throw new EntityNotFoundException("No contractors were found in the database for the state provided.");
        }
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

    /*Service to delete contractor by id. Takes in UUID that has been converted from a String. If contractor with
    the user provided ID isn't found an Entity Not Found Exception is thrown.*/
    public Optional<Contractor> deleteContractorById(UUID id) throws EntityNotFoundException{
        Optional<Contractor> contractor = contractorRepository.findById(id);

        System.out.println("Contractor test " + contractor);

        if(contractor.isPresent()){
            System.out.println("Contractor exists. Delete operation is next.");
            contractorRepository.deleteById(id);
        } else{
            throw new EntityNotFoundException("No contractors were found with that ID. No deletion occurred.");
        }

        return contractor;
    }

    public Contractor updateContractorById(String stringID, Contractor contractor) throws EntityNotFoundException{

        //Convert stringID to correct UUID format so we can use the findById method.
        UUID contractorID = convertStringToUUIDFormat(stringID);
        Optional<Contractor> contractor1 = contractorRepository.findById(contractorID);

       /* Checking if contractor exists in the database. If Contractor exists, we will update the properties and save.
        Otherwise, we will throw an entity not found error.*/
        if(contractor1.isPresent()){
            /*We create 'contractor2' so we can access the Contractor methods. Contractor1 is of 'Optional' type and
            therefore we cant access the methods on it.*/
            Contractor contractor2 = contractor1.get();
            contractor2.setName(contractor.getName());
            contractor2.setStreet(contractor.getStreet());
            contractor2.setCity(contractor.getCity());
            contractor2.setState(contractor.getState());
            contractor2.setZip(contractor.getZip());

            //Save contractor and return it.
            contractorRepository.save(contractor2);
            return contractor2;

        } else{
            throw new EntityNotFoundException("No contractors were found with that ID. No update occurred.");
        }

    }
}
