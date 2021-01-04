package com.isurunix.graphqldemo.service.impl;

import com.isurunix.graphqldemo.domain.user.CustomerDTO;
import com.isurunix.graphqldemo.repository.CustomerRepository;
import com.isurunix.graphqldemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> findAll() {
        return customerRepository.findAll()
                .stream()
                .map(customer -> {
                    CustomerDTO customerDTO = new CustomerDTO();
                    customerDTO.setCustomerCode(customer.getCustomerCode());
                    customerDTO.setAddress(customer.getAddress());
                    customerDTO.setContactNo(customer.getContactNo());
                    customerDTO.setUserId(customer.getUser().getUserId());
                    return customerDTO;
                }).collect(Collectors.toList());
    }
}
