package com.isurunix.graphqldemo.entity;

import javax.persistence.*;

@Entity
@Table(name = "registered_service")
public class RegisteredService {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cust_code", referencedColumnName = "customer_code")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "service_id")
    private PortalService service;

    @Column(name = "status")
    private Short status;
}
