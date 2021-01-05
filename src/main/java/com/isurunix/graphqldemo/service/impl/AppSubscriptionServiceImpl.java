package com.isurunix.graphqldemo.service.impl;

import com.isurunix.graphqldemo.domain.AppSubscription;
import com.isurunix.graphqldemo.repository.AppSubscriptionRepository;
import com.isurunix.graphqldemo.service.AppSubscriptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AppSubscriptionServiceImpl implements AppSubscriptionService {

    private final AppSubscriptionRepository appSubscriptionRepository;

    public AppSubscriptionServiceImpl(AppSubscriptionRepository appSubscriptionRepository) {
        this.appSubscriptionRepository = appSubscriptionRepository;
    }

    @Override
    public List<AppSubscription> findAllAppSubscriptions(String customerId, Integer status) {
        log.info("Fetching all app subscriptions,customerId:[{}], status:[{}]",customerId, status);
        List<AppSubscription> subscriptions = appSubscriptionRepository.findAllByCustomerCodeAndStatus(customerId, status);
        log.info("Fetched [{}] subscriptions", subscriptions.size());
        return subscriptions;
    }

    @Override
    public AppSubscription updateAppSubscription(AppSubscription subscription) {
        return null;
    }

    @Override
    public AppSubscription createAppSubscription(AppSubscription subscription) {
        return null;
    }
}
