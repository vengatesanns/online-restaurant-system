package com.hackprotech.securityservice.service;

import com.hackprotech.securityservice.dao.CustomerRepository;
import com.hackprotech.securityservice.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CustomerService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByUsername(username);
        if (Objects.isNull(customer)) {
            throw new UsernameNotFoundException("User not found in the DB");
        }
        return customer;
    }
}
