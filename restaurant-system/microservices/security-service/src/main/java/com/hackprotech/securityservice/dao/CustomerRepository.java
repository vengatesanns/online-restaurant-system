package com.hackprotech.securityservice.dao;

import com.hackprotech.securityservice.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer findByUsername(String username);

}
