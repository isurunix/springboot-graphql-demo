package com.isurunix.graphqldemo.entity;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "customer_code")
    private String customerCode;

    @Column(name = "contact_no")
    private String contactNo;

    @Column(name = "address", length = 500)
    private String address;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;
}
