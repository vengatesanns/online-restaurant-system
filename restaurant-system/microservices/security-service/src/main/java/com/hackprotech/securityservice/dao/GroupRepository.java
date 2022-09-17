package com.hackprotech.securityservice.dao;

import com.hackprotech.securityservice.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {

    Group findByGroupName(String groupName);

}
