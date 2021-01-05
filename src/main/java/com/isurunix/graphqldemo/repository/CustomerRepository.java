package com.isurunix.graphqldemo.repository;

import com.isurunix.graphqldemo.dto.user.CustomerDTO;
import com.isurunix.graphqldemo.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
