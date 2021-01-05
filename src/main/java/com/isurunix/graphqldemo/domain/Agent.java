package com.isurunix.graphqldemo.domain;

import javax.persistence.*;

@Entity
@Table(name = "agent")
public class Agent {
    @Id
    @GeneratedValue
    @Column(name = "agent_id")
    private Long agentId;

    @Column(name = "agent_name")
    private String agentName;
}
