package com.isurunix.graphqldemo.resolver;

import com.isurunix.graphqldemo.domain.Customer;
import com.isurunix.graphqldemo.domain.User;
import com.isurunix.graphqldemo.dto.LoginResponse;
import com.isurunix.graphqldemo.security.JWTUserDetails;
import com.isurunix.graphqldemo.service.CustomerService;
import com.isurunix.graphqldemo.service.UserDetailService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class UserMutationResolver implements GraphQLMutationResolver {
    private final static Logger LOGGER = LoggerFactory.getLogger(UserMutationResolver.class);
    private final UserDetailService userDetailService;
    private final AuthenticationProvider authenticationProvider;
    private final CustomerService customerService;

    @PreAuthorize("isAnonymous()")
    public LoginResponse login(String username, String password) {
        UsernamePasswordAuthenticationToken credentials = new UsernamePasswordAuthenticationToken(username, password);
        try {
            SecurityContextHolder.getContext().setAuthentication(authenticationProvider.authenticate(credentials));
            String currentUser = userDetailService.getCurrentUser().getUsername();
            JWTUserDetails userDetails = userDetailService.findUserByUsername(currentUser);
            return new LoginResponse(currentUser,
                    customerService.findCustomerByUsername(currentUser),userDetails.getToken());
        } catch (AuthenticationException ex) {
            LOGGER.error("Error authenticating user", ex);
            throw new BadCredentialsException("Username or password is incorrect");
        }
    }
}
