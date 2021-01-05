package com.isurunix.graphqldemo.service.impl;

import com.isurunix.graphqldemo.domain.App;
import com.isurunix.graphqldemo.domain.AppSubscription;
import com.isurunix.graphqldemo.domain.Customer;
import com.isurunix.graphqldemo.dto.CreateAppSubscriptionInput;
import com.isurunix.graphqldemo.exceptions.ResourceNotFoundException;
import com.isurunix.graphqldemo.repository.AppRepository;
import com.isurunix.graphqldemo.repository.AppSubscriptionRepository;
import com.isurunix.graphqldemo.repository.CustomerRepository;
import com.isurunix.graphqldemo.service.AppSubscriptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AppSubscriptionServiceImpl implements AppSubscriptionService {

    private final AppSubscriptionRepository appSubscriptionRepository;
    private final AppRepository appRepository;
    private final CustomerRepository customerRepository;

    public AppSubscriptionServiceImpl(AppSubscriptionRepository appSubscriptionRepository,
                                      AppRepository appRepository,
                                      CustomerRepository customerRepository) {
        this.appSubscriptionRepository = appSubscriptionRepository;
        this.appRepository = appRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<AppSubscription> findAllAppSubscriptions(Integer customerId, Integer status) {
        log.info("Fetching all app subscriptions,customerId:[{}], status:[{}]", customerId, status);
        List<AppSubscription> subscriptions = appSubscriptionRepository.findAllByCustomerCodeAndStatus(customerId, status);
        log.info("Fetched [{}] subscriptions", subscriptions.size());
        return subscriptions;
    }

    @Override
    public AppSubscription updateAppSubscription(AppSubscription subscription) {
        return null;
    }

    @Override
    public AppSubscription createAppSubscription(CreateAppSubscriptionInput input) {
        App app = appRepository.findById(input.getAppId().longValue())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Requesting app [{" + input.getAppId() + "}] does not exist"));
        Customer customer = customerRepository.findById(input.getCustomerCode())
                .orElseThrow(() -> new ResourceNotFoundException("Invalid customer code: " + input.getCustomerCode()));
        AppSubscription subscription = new AppSubscription();
        subscription.setApp(app);
        subscription.setCustomer(customer);
        subscription.setStatus((short)1);
        return appSubscriptionRepository.save(subscription);
    }
}
