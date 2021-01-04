package com.isurunix.graphqldemo.service;

import com.isurunix.graphqldemo.domain.AppSubscription;

import java.util.List;

public interface AppSubscriptionService {
    List<AppSubscription> findAllAppSubscriptions(String customerId, Integer status);
    AppSubscription updateAppSubscription(AppSubscription subscription);
    AppSubscription createAppSubscription(AppSubscription subscription);
}
