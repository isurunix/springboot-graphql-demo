package com.isurunix.graphqldemo.resolver;

import com.isurunix.graphqldemo.domain.Customer;
import com.isurunix.graphqldemo.service.CustomerService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class CustomerQueryResolver implements GraphQLQueryResolver {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerQueryResolver.class);

    private final CustomerService customerService;

    public CustomerQueryResolver(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PreAuthorize("isAuthenticated()")

    public List<Customer> findAllCustomers(){
        LOGGER.info("Requesting all customers");
        List<Customer> customers = customerService.findAll();
        LOGGER.info("Fetched all customers [{}]", customers.size());
        return customers;
    }
}

@Component
class CustomerMutationResolver implements GraphQLMutationResolver {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerQueryResolver.class);
    private final CustomerService customerService;

    public CustomerMutationResolver(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PreAuthorize("isAnonymous()")
    public Customer createCustomer(String username, String password, String contactNo, String address){
        LOGGER.info("Creating new customer, [{},{},{},{}]", username, password, contactNo, address);
        return customerService.createCustomer(username, password, contactNo, address);
    }

    public Boolean deleteCustomer(Integer customerCode) {
        LOGGER.info("Deleting customer: [{}]", customerCode);
        return customerService.deleteCustomer(customerCode);
    }

    public Customer updateCustomer(Integer customerCode, String contactNo, String address){
        LOGGER.info("Updating customer: [{}, /{{},{}/}]", customerCode, contactNo, address);
        return customerService.updateCustomer(customerCode, contactNo, address);
    }
}
