package com.contractManagementPortal.demo.repository;

import com.contractManagementPortal.demo.entities.Agreement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

//CRUD repository will give us CRUD operations.
@Repository
public interface AgreementRepository extends CrudRepository<Agreement, UUID> {



}
