package com.isurunix.graphqldemo.service;

import com.isurunix.graphqldemo.domain.Customer;

import java.util.List;

public interface CustomerService {
    /**
     * Returns list all registered customers
     * @return the list of registered customers
     */
    List<Customer> findAll();

    /**
     * Creates new customer
     * @param username  the username of the customer. This is the username customer uses to login
     * @param password  password for the customer's user account
     * @param contactNo the contact number
     * @param address   the address
     * @return the new customer
     */
    Customer createCustomer(String username, String password, String contactNo, String address);

    /**
     * Removes an existing customer having the given customer code
     * @param customerCode  the customer code of the removed customer
     * @return  true if customer removed successfully
     */
    Boolean deleteCustomer(Integer customerCode);

    /**
     * Modifies the details of an existing customer
     * @param customerCode  the customer code for the customer being modified
     * @param contactNo new contact number
     * @param address   new address
     * @return  the updated customer
     */
    Customer updateCustomer(Integer customerCode, String contactNo, String address);
}
