package com.isurunix.graphqldemo.resolver;

import com.isurunix.graphqldemo.domain.user.CustomerDTO;
import com.isurunix.graphqldemo.repository.CustomerRepository;
import com.isurunix.graphqldemo.service.CustomerService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class CustomerQueryResolver implements GraphQLQueryResolver {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerQueryResolver.class);

    private final CustomerService customerService;

    public CustomerQueryResolver(CustomerService customerService) {
        this.customerService = customerService;
    }

    public List<CustomerDTO> findAllCustomers(){
        LOGGER.info("Requesting all customers");
        List<CustomerDTO> customers = customerService.findAll();
        LOGGER.info("Fetched all customers [{}]", customers.size());
        return customers;
    }
}
