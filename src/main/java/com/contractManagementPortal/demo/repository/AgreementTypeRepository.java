package com.contractManagementPortal.demo.repository;

import com.contractManagementPortal.demo.entities.AgreementType;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AgreementTypeRepository extends CrudRepository<AgreementType, Long> {
}
