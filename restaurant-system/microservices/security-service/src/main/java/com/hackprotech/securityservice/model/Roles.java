package com.hackprotech.securityservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String roleName;

    private Date createdDateTime;
    private Date updatedDateTime;

}
