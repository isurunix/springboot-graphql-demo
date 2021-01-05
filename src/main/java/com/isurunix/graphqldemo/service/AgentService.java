package com.isurunix.graphqldemo.service;

import com.isurunix.graphqldemo.domain.Agent;

import java.util.List;

public interface AgentService {
    List<Agent> findAllAgents();
}
