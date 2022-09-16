package com.hackprotech.securityservice.service;

import com.hackprotech.securityservice.dao.UserRepository;
import com.hackprotech.securityservice.model.AppUser;
import com.hackprotech.securityservice.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AppUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser appUser = userRepository.findByEmail(email);
        if (Objects.isNull(appUser)) {
            throw new UsernameNotFoundException("User not found");
        }

        UserDetails user = User.builder()
                .username(appUser.getEmail())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .password(appUser.getPassword())
                .authorities(new SimpleGrantedAuthority("READ"))
                .build();
        return user;
    }


  /*  private List<String> addRoles(AppUser appUser) {
        List<GrantedAuthority> roles = new ArrayList<>(appUser.getGroups().size());
        for (Group group : appUser.getGroups()) {
            roles.add(new SimpleGrantedAuthority(group.getGroupName()));
        }
    }*/


}
