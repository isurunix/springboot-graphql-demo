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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public PortalService getService() {
        return service;
    }

    public void setService(PortalService service) {
        this.service = service;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }
}
