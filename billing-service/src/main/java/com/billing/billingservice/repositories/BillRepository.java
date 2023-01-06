package com.billing.billingservice.repositories;

import com.billing.billingservice.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;


@RepositoryRestResource
public interface BillRepository extends JpaRepository<Bill,Long> {

    Collection<Bill> findBillsByCustomerID(Long customerId);
}
