package com.isurunix.graphqldemo.domain;

import javax.persistence.*;

@Entity
@Table(name = "app_subscription")
public class AppSubscription {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cust_code", referencedColumnName = "customer_code")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "app_id", referencedColumnName = "app_id")
    private App app;

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

    public App getApp() {
        return app;
    }

    public void setApp(App app) {
        this.app = app;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }
}
