package com.contractManagementPortal.demo.repository;

import com.contractManagementPortal.demo.entities.PaymentType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PaymentTypeRepository extends CrudRepository<PaymentType, Long> {

}
