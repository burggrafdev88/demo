package com.contractManagementPortal.demo.repository;

import com.contractManagementPortal.demo.entities.BidType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BidTypeRepository extends CrudRepository<BidType, Long> {
}
