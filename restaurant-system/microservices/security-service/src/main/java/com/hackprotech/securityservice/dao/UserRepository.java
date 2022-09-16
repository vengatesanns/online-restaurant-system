package com.hackprotech.securityservice.dao;

import com.hackprotech.securityservice.model.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<AppUser, Long> {

    AppUser findByEmail(String email);

}
