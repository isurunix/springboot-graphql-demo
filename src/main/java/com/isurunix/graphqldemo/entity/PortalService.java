package com.isurunix.graphqldemo.entity;

import javax.persistence.*;

@Entity
@Table(name = "portal_service")
public class PortalService {
    @Id
    @GeneratedValue
    @Column(name = "service_id")
    private Long serviceId;

    @Column(name = "service_name")
    private String serviceName;
}
