package com.isurunix.graphqldemo.resolver;

import com.isurunix.graphqldemo.domain.Customer;
import com.isurunix.graphqldemo.dto.user.CustomerDTO;
import com.isurunix.graphqldemo.service.CustomerService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class CustomerQueryResolver implements GraphQLQueryResolver {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerQueryResolver.class);

    private final CustomerService customerService;

    public CustomerQueryResolver(CustomerService customerService) {
        this.customerService = customerService;
    }

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

    public void saveCustomer(CustomerDTO customer){

    }
}
