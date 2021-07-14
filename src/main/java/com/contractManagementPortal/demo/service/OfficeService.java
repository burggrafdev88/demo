package com.contractManagementPortal.demo.service;

import com.contractManagementPortal.demo.entities.Office;
import com.contractManagementPortal.demo.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OfficeService {

    @Autowired
    private OfficeRepository officeRepository;

    /*Service to create an office.*/
    public Optional<Office> createOffice(Office office){
        System.out.println("Office: " + office.getOffice());

        //If the office is not empty, save the record, then return it. Otherwise, return empty.
        if(!office.getOffice().isEmpty()) {

            System.out.println("All fields filled in, save will now be executed.");
            office = officeRepository.save(office);
            return Optional.of(office);

        } else{
            System.out.println("Not all the fields are filled in.");
            return Optional.empty();
        }
    }
}
