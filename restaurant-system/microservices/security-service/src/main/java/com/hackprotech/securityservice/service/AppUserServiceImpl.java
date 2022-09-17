package com.hackprotech.securityservice.service;

import com.hackprotech.securityservice.constants.UserRoles;
import com.hackprotech.securityservice.dao.AppUserRepository;
import com.hackprotech.securityservice.dao.GroupRepository;
import com.hackprotech.securityservice.exceptions.AppUserServiceException;
import com.hackprotech.securityservice.exceptions.UserAlreadyExistsException;
import com.hackprotech.securityservice.model.AppUser;
import com.hackprotech.securityservice.model.Group;
import com.hackprotech.securityservice.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AppUserServiceImpl implements UserDetailsService, AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // @formatter:off
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByEmail(email);
        if (Objects.isNull(appUser)) {
            throw new UsernameNotFoundException("User not found");
        }

        UserDetails user = User.builder()
                .username(appUser.getEmail())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .password(appUser.getPassword())
                .authorities(new SimpleGrantedAuthority("READ")).build();
        return user;
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

            Group group = groupRepository.findByGroupName(UserRoles.CUSTOMER.toString());

            newUser.getGroups().add(group);
            appUserRepository.save(newUser);

        } catch (UserAlreadyExistsException userAlreadyExistsException) {
            throw userAlreadyExistsException;
        } catch (Exception ex) {
            throw new AppUserServiceException("Error While SignUp!");
        }
    }


  /*  private List<String> addRoles(AppUser appUser) {
        List<GrantedAuthority> roles = new ArrayList<>(appUser.getGroups().size());
        for (Group group : appUser.getGroups()) {
            roles.add(new SimpleGrantedAuthority(group.getGroupName()));
        }
    }*/


}
