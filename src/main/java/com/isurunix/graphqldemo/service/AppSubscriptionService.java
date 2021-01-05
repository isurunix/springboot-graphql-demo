package com.isurunix.graphqldemo.service;

import com.isurunix.graphqldemo.domain.AppSubscription;
import com.isurunix.graphqldemo.dto.CreateAppSubscriptionInput;

import java.util.List;

public interface AppSubscriptionService {
    List<AppSubscription> findAllAppSubscriptions(Integer customerId, Integer status);
    AppSubscription updateAppSubscription(AppSubscription subscription);
    AppSubscription createAppSubscription(CreateAppSubscriptionInput subscription);
}
