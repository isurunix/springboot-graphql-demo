package com.isurunix.graphqldemo.service.impl;

import com.isurunix.graphqldemo.domain.Customer;
import com.isurunix.graphqldemo.domain.User;
import com.isurunix.graphqldemo.exceptions.DuplicateResourceException;
import com.isurunix.graphqldemo.exceptions.ResourceNotFoundException;
import com.isurunix.graphqldemo.repository.CustomerRepository;
import com.isurunix.graphqldemo.repository.UserRepository;
import com.isurunix.graphqldemo.service.CustomerService;
import com.isurunix.graphqldemo.service.UserDetailService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;
    private final UserDetailService userDetailService;

    public CustomerServiceImpl(CustomerRepository customerRepository,
                               UserRepository userRepository,
                               UserDetailService userDetailService) {
        this.customerRepository = customerRepository;
        this.userRepository = userRepository;
        this.userDetailService = userDetailService;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    @Transactional
    public Customer createCustomer(String username, String password, String contactNo, String address) {
        if(userRepository.findByUsername(username).isPresent()){
            throw new DuplicateResourceException("Username already taken. Please choose another");
        }
        User user = userDetailService.createUser(username,password);
        return customerRepository.save(new Customer(contactNo, address, user));
    }

    @Override
    public Boolean deleteCustomer(Integer customerCode) {
        Customer customer = customerRepository.findById(customerCode)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid customer code: [" + customerCode + "]"));
        customerRepository.delete(customer);
        return true;
    }

    @Override
    public Customer updateCustomer(Integer customerCode, String contactNo, String address) {
        Customer customer = customerRepository.findById(customerCode)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid customer code: [" + customerCode + "]"));
        customer.setAddress(address);
        customer.setContactNo(contactNo);
        return customerRepository.save(customer);
    }

    @Override
    public Customer findCustomerByUsername(String username) {
        return customerRepository.findByUser_Username(username)
                .orElseThrow(() -> new ResourceNotFoundException("No customer profile for user: [" + username + "]"));
    }
}
