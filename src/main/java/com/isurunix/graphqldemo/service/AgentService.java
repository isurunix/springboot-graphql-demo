package com.isurunix.graphqldemo.service;

import com.isurunix.graphqldemo.domain.Agent;

import java.util.List;

/**
 * This encapsulates all the functionalities that are supported by the AgentService
 * @author isuru
 */
public interface AgentService {
    /**
     * Get the list of all the agents
     * @return  the list of agent
     */
    List<Agent> findAllAgents();
}
