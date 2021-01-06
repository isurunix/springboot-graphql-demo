package com.isurunix.graphqldemo.service;

import com.isurunix.graphqldemo.domain.User;
import com.isurunix.graphqldemo.security.JWTUserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserDetailService extends UserDetailsService {
    JWTUserDetails findUserByUsername(String username);
    JWTUserDetails findUserByToken(String token);
    User getCurrentUser();
    User createUser(String username, String password);
}
