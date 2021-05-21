package com.contractManagementPortal.demo;

import com.contractManagementPortal.demo.contractor.Contractor;
//import com.contractManagementPortal.demo.service.contractorDOAService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

////Using command line runner to create and insert contractors into the database at the start of the program.
//@Component
//public class ContractorDAOServiceCommandLineRunner implements CommandLineRunner {
//
//    //Logger
//    private static final Logger log = LoggerFactory.getLogger(ContractorDAOServiceCommandLineRunner.class);
//
//    //Creating service allows us to insert the contractors once they are created.
//    @Autowired
//    private contractorDOAService contractorDOAService;
//
//    //Insert contractor.
//    @Override
//    public void run(String... args) throws Exception {
//        Contractor contractor = new Contractor("Eric's Consulting Services", "2219 West 79th Terrace", "Prairie Village",
//                "Kansas", "66208");
//        long id = contractorDOAService.insert(contractor);
//        log.info("New contractor is created. " + contractor);
//    }
//
//
//}
