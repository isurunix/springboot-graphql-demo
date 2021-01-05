package com.isurunix.graphqldemo.service.impl;

import com.isurunix.graphqldemo.domain.Agent;
import com.isurunix.graphqldemo.repository.AgentRepository;
import com.isurunix.graphqldemo.service.AgentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentServiceImpl implements AgentService {

    private final AgentRepository agentRepository;

    public AgentServiceImpl(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    @Override
    public List<Agent> findAllAgents() {
        return agentRepository.findAll();
    }
}
