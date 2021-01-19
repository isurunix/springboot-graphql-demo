package com.isurunix.graphqldemo.dto;

import com.isurunix.graphqldemo.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private String username;
    private Customer profile;
    private String token;
}
