package com.isurunix.graphqldemo.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.isurunix.graphqldemo.domain.User;
import com.isurunix.graphqldemo.exceptions.BadTokenException;
import com.isurunix.graphqldemo.exceptions.ResourceNotFoundException;
import com.isurunix.graphqldemo.repository.UserRepository;
import com.isurunix.graphqldemo.security.JWTUserDetails;
import com.isurunix.graphqldemo.service.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailService {
    private final UserRepository userRepository;
    private final SecurityProperties properties;
    private final Algorithm algorithm;
    private final JWTVerifier verifier;
    private final PasswordEncoder passwordEncoder;

    @Override
    public JWTUserDetails findUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(user -> getUserDetails(user, getToken(user)))
                .orElseThrow(() -> new UsernameNotFoundException("Username or password didn''t match"));
    }


    @Transactional
    @Override
    public JWTUserDetails findUserByToken(String token) {
        return getDecodedToken(token)
                .map(DecodedJWT::getSubject)
                .flatMap(userRepository::findByUsername)
                .map(user -> getUserDetails(user, token))
                .orElseThrow(BadTokenException::new);
    }

    public User getCurrentUser() {
        return Optional
                .ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .map(Authentication::getName)
                .flatMap(userRepository::findByUsername)
                .orElse(null);
    }

    @Override
    public JWTUserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository
                .findByUsername(s)
                .map(user -> getUserDetails(user, getToken(user)))
                .orElseThrow(() -> new UsernameNotFoundException("Username or password didn''t match"));
    }

    public User createUser(String username, String password){
        User user = new User(username,passwordEncoder.encode(password));
        return userRepository.save(user);
    }

    private JWTUserDetails getUserDetails(User user, String token) {
        return JWTUserDetails
                .builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(getUserRoles(user.getUsername()).stream().map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList()))
                .token(token)
                .build();
    }

    private List<String> getUserRoles(String username) {
        return Collections.emptyList();
    }

    private Optional<DecodedJWT> getDecodedToken(String token) {
        try {
            return Optional.of(verifier.verify(token));
        } catch(JWTVerificationException ex) {
            return Optional.empty();
        }
    }

    public String getToken(User user) {
        Instant now = Instant.now();
        Instant expiry = Instant.now().plus(Duration.ofHours(4));
        return JWT
                .create()
                .withIssuer("isurunix")
                .withIssuedAt(Date.from(now))
                .withExpiresAt(Date.from(expiry))
                .withSubject(user.getUsername())
                .withClaim("uid", user.getUserId())
                .sign(algorithm);
    }


}
