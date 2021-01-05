package com.isurunix.graphqldemo.service;

import com.isurunix.graphqldemo.domain.Customer;
import com.isurunix.graphqldemo.dto.user.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer createCustomer(String username, String password, String contactNo, String address);
    Boolean deleteCustomer(Integer customerCode);
    Customer updateCustomer(Integer customerCode, String contactNo, String address);
}
