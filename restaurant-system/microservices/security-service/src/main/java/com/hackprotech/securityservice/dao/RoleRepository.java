package com.hackprotech.securityservice.dao;

import com.hackprotech.securityservice.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles, Long> {

    Roles findByRoleName(String roleName);

}
