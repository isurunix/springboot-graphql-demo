package com.isurunix.graphqldemo.service;

import com.isurunix.graphqldemo.domain.User;
import com.isurunix.graphqldemo.security.JWTUserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserDetailService extends UserDetailsService {
    /**
     * Returns user details for a logged in user
     * @param username the username of the user
     * @return  user details including jwt token
     */
    JWTUserDetails findUserByUsername(String username);

    /**
     * Return user details for a logged in user using the token
     * @param token the jwt token
     * @return the user details for the user for whom the token belongs to
     */
    JWTUserDetails findUserByToken(String token);

    /**
     * Returns the details of the user making the request
     * @return the user
     */
    User getCurrentUser();

    /**
     * Creates a new user account
     * @param username  the username for the account
     * @param password  the password of the account
     * @return  the created user
     */
    User createUser(String username, String password);
}
