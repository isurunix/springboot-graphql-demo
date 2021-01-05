package com.isurunix.graphqldemo.resolver;

import com.isurunix.graphqldemo.domain.App;
import com.isurunix.graphqldemo.domain.AppSubscription;
import com.isurunix.graphqldemo.dto.CreateAppSubscriptionInput;
import com.isurunix.graphqldemo.service.AppService;
import com.isurunix.graphqldemo.service.AppSubscriptionService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
class AppQueryResolver implements GraphQLQueryResolver {

    private final AppService appService;
    private final AppSubscriptionService appSubscriptionService;

    public AppQueryResolver(AppService appService, AppSubscriptionService appSubscriptionService) {
        this.appService = appService;
        this.appSubscriptionService = appSubscriptionService;
    }

    public List<App> findAllApps() {
        return appService.findAllApps();
    }

    public App findAppById(Integer appId){
        return appService.findAppById(appId);
    }

    public List<AppSubscription> findAllAppSubscriptions(String customerId, Integer status){
        return appSubscriptionService.findAllAppSubscriptions(customerId, status);
    }
}

@Component
class AppMutationResolver implements GraphQLMutationResolver {
    private final AppService appService;
    private final AppSubscriptionService appSubscriptionService;

    public AppMutationResolver(AppService appService, AppSubscriptionService appSubscriptionService) {
        this.appService = appService;
        this.appSubscriptionService = appSubscriptionService;
    }

    public AppSubscription saveAppSubscription(CreateAppSubscriptionInput input){
        return appSubscriptionService.createAppSubscription(input);
    }
}
