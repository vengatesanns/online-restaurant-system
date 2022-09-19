package com.hackprotech.securityservice.service.impl;

import com.hackprotech.securityservice.constants.UserRoles;
import com.hackprotech.securityservice.dao.AppUserRepository;
import com.hackprotech.securityservice.dao.RoleRepository;
import com.hackprotech.securityservice.exceptions.AppUserServiceException;
import com.hackprotech.securityservice.exceptions.UserAlreadyExistsException;
import com.hackprotech.securityservice.model.AppUser;
import com.hackprotech.securityservice.model.Roles;
import com.hackprotech.securityservice.request.UserRequest;
import com.hackprotech.securityservice.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // @formatter:off
    @Override
    public AppUser validateLoginUser(String email) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByEmail(email);
        if (Objects.isNull(appUser)) {
            throw new UsernameNotFoundException("User not found");
        }
        return appUser;
    }
    // @formatter:on

    @Override
    public void signUpUser(UserRequest userRequest) {
        try {
            AppUser appUser = appUserRepository.findByEmail(userRequest.getEmail());

            if (Objects.nonNull(appUser)) {
                throw new UserAlreadyExistsException("User Already Exists!");
            }

            AppUser newUser = new AppUser();
            newUser.setFirstName(userRequest.getFirstName());
            newUser.setLastName(userRequest.getLastName());
            newUser.setPassword(passwordEncoder.encode(userRequest.getPassword()));
            newUser.setEmail(userRequest.getEmail().toLowerCase());
            newUser.setPhoneNumber(userRequest.getPhoneNumber());
            newUser.setEnabled(Boolean.TRUE);
            newUser.setAccountNonExpired(Boolean.TRUE);
            newUser.setAccountNonLocked(Boolean.TRUE);
            newUser.setCredentialsNonExpired(Boolean.TRUE);
            newUser.setCreatedDateTime(Date.from(Instant.now()));
            newUser.setUpdatedDateTime(Date.from(Instant.now()));

            Roles roles = roleRepository.findByRoleName(UserRoles.CUSTOMER.toString());

            newUser.getRoles().add(roles);
            appUserRepository.save(newUser);

        } catch (UserAlreadyExistsException userAlreadyExistsException) {
            throw userAlreadyExistsException;
        } catch (Exception ex) {
            throw new AppUserServiceException("Error While SignUp!");
        }
    }

}
