package com.contractManagementPortal.demo.service;

import com.contractManagementPortal.demo.entities.BidType;
import com.contractManagementPortal.demo.repository.BidTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BidTypeService {
    @Autowired
    private BidTypeRepository bidTypeRepository;

    //Service to create a new bid type.
    public Optional<BidType> createBidType(BidType bidType){
        System.out.println("Create bid type called from bid type service.");

        if(!bidType.getType().isEmpty()){
            System.out.println("All fields filled in. Save will now be executed.");

            bidTypeRepository.save(bidType);
            return Optional.of(bidType);

        } else {
            return Optional.empty();
        }


    }
}
