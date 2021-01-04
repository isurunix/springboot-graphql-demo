package com.isurunix.graphqldemo.resolver;

import com.isurunix.graphqldemo.domain.App;
import com.isurunix.graphqldemo.domain.AppSubscription;
import com.isurunix.graphqldemo.service.AppService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
class AppQueryResolver implements GraphQLQueryResolver {

    private final AppService appService;

    public AppQueryResolver(AppService appService) {
        this.appService = appService;
    }

    public List<App> findAllApps() {
        return appService.findAllApps();
    }

    public App findAppById(Integer appId){
        return appService.findAppById(appId);
    }

    public List<AppSubscription> findAllAppSubscriptions(String customerId, int status){
        return Collections.emptyList();
    }
}