package com.contractManagementPortal.demo.repository;

import com.contractManagementPortal.demo.contractor.Contractor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractorRepository extends JpaRepository<Contractor, Long> {

}
