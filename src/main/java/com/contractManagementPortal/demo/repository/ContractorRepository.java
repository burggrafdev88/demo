package com.contractManagementPortal.demo.repository;

import com.contractManagementPortal.demo.entities.Contractor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


//CRUD repository will give us CRUD operations.
@Repository
public interface ContractorRepository extends CrudRepository<Contractor, UUID> {

    //Method to find contractors by state.
    List<Contractor> findByState(@Param("state") String state);

}
