package com.isurunix.graphqldemo.entity;

import javax.persistence.*;

@Entity
@Table(name = "agent")
public class Agent {
    @Id
    @GeneratedValue
    @Column(name = "agent_id")
    private Long agentId;

    @Column(name = "name")
    private String agentName;
}
