package com.isurunix.graphqldemo.resolver;

import com.isurunix.graphqldemo.domain.Agent;
import com.isurunix.graphqldemo.service.AgentService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class AgentQueryResolver implements GraphQLQueryResolver {
    private final AgentService agentService;

    public AgentQueryResolver(AgentService agentService) {
        this.agentService = agentService;
    }

    public List<Agent> findAllAgents(){
        return agentService.findAllAgents();
    }
}

@Component
class AgentMutationResolver implements GraphQLMutationResolver {

}
