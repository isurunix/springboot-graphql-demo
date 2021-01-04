package com.isurunix.graphqldemo.service;

import com.isurunix.graphqldemo.domain.Customer;
import com.isurunix.graphqldemo.dto.user.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
}
