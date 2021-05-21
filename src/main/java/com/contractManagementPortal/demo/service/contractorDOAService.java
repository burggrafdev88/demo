//package com.contractManagementPortal.demo.service;
//
//import com.contractManagementPortal.demo.contractor.Contractor;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//
//
//@Repository
//@Transactional
//public class contractorDOAService {
//        @PersistenceContext
//        private EntityManager entityManager;
//
//        public long insert(Contractor contractor){
//            entityManager.persist(contractor);
//            return contractor.getId();
//        }
//}
