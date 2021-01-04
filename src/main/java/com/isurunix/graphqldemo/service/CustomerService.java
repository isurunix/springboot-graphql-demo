package com.isurunix.graphqldemo.service;

import com.isurunix.graphqldemo.domain.user.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> findAll();
}
