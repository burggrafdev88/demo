package com.contractManagementPortal.demo.service;

import com.contractManagementPortal.demo.entities.Agreement;
import com.contractManagementPortal.demo.entities.Contractor;
import com.contractManagementPortal.demo.repository.AgreementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AgreementService {

    @Autowired
    private AgreementRepository agreementRepository;

    /* Service to create a new agreement. Service creates the id for the agreement as this is not created
     on the front end. Used to return a boolean!!*/
    public Optional<Agreement> createAgreement(Agreement agreement) {

        System.out.println("Agreement name: " + agreement.getAgreementName());

        if(!agreement.getAgreementName().isEmpty() && !agreement.getPocFirstName().isEmpty()
                && !agreement.getPocLastName().isEmpty() && !agreement.getPocEmail().isEmpty()
                && agreement.getBeginDate() != null && agreement.getExpirationDate() != null
                && agreement.getAmount() != null && agreement.getAgreementType() != null
                && agreement.getOffice() != null & agreement.getContractor() != null) {

            System.out.println("All fields filled in, save will now be executed.");
            agreementRepository.save(agreement);

            return Optional.of(agreement);

        } else{
            System.out.println("Not all the fields are filled in.");

            return Optional.empty();
        }
    }

    /*Service to return all agreements in the db.  If no agreements are found, an Entity not found
    Exception is thrown.*/
    public List<Agreement> listAllAgreements(){
        List<Agreement> agreements = (List<Agreement>) agreementRepository.findAll();

        if(!agreements.isEmpty()){
            System.out.print("Agreement list is empty!");
            return agreements;
        } else{
            throw new EntityNotFoundException("No agreements were found in the database.");
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

    /*Service to delete agreement by id. Takes in UUID that has been converted from a String. If agreement with
    the user provided ID isn't found an Entity Not Found Exception is thrown.*/
    public Optional<Agreement> deleteAgreementById(UUID id) throws EntityNotFoundException{
        Optional<Agreement> agreement = agreementRepository.findById(id);

        System.out.println("Agreement test " + agreement);

        if(agreement.isPresent()){
            System.out.println("Agreement exists. Delete operation is next.");
            agreementRepository.deleteById(id);
        } else{
            throw new EntityNotFoundException("No agreements were found with that ID. No deletion occurred.");
        }

        return agreement;
    }

    public Agreement updateAgreementById(String stringID, Agreement agreement) throws EntityNotFoundException{

        //Convert stringID to correct UUID format so we can use the findById method.
        UUID agreementID = convertStringToUUIDFormat(stringID);
        Optional<Agreement> agreement1 = agreementRepository.findById(agreementID);

       /* Checking if agreement exists in the database. If Agreement exists, we will update the properties and save.
        Otherwise, we will throw an entity not found error.*/
        if(agreement1.isPresent()){
            /*We create 'agreement2' so we can access the Agreement methods. Agreement1 is of 'Optional' type and
            therefore we cant access the methods on it.*/
            Agreement agreement2 = agreement1.get();
            agreement2.setAgreementName(agreement.getAgreementName());
            agreement2.setPocFirstName(agreement.getPocFirstName());
            agreement2.setPocLastName(agreement.getPocLastName());
            agreement2.setPocEmail(agreement.getPocEmail());
            agreement.setPocPhoneNumber(agreement.getPocPhoneNumber());
            agreement2.setBeginDate(agreement.getBeginDate());
            agreement2.setExpirationDate(agreement.getExpirationDate());
            agreement2.setAmount(agreement.getAmount());

            //Save agreement and return it.
            agreementRepository.save(agreement2);
            return agreement2;

        } else{
            throw new EntityNotFoundException("No agreements were found with that ID. No update occurred.");
        }

    }
}
