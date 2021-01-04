package com.isurunix.graphqldemo.service.impl;

import com.isurunix.graphqldemo.domain.Customer;
import com.isurunix.graphqldemo.dto.user.CustomerDTO;
import com.isurunix.graphqldemo.repository.CustomerRepository;
import com.isurunix.graphqldemo.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
