package com.contractManagementPortal.demo.service;

import com.contractManagementPortal.demo.entities.AgreementType;
import com.contractManagementPortal.demo.repository.AgreementTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AgreementTypeService {

    @Autowired
    AgreementTypeRepository agreementTypeRepository;

    public Optional<AgreementType> createAgreementType(AgreementType agreementType){
        //set UUID for unique ID as this is not created on the front end.
//        agreementType.setId(UUID.randomUUID());

        System.out.println("Agreement type: " + agreementType.getType());

        //If the paymentType has a type, save the record, then return it. Otherwise, return empty.
        if(!agreementType.getType().isEmpty()) {

            System.out.println("All fields filled in, save will now be executed.");
            agreementType = agreementTypeRepository.save(agreementType);
            return Optional.of(agreementType);

        } else{
            System.out.println("Not all the fields are filled in.");
            return Optional.empty();
        }

    }
}
