package com.isurunix.graphqldemo.service;

import com.isurunix.graphqldemo.domain.AppSubscription;
import com.isurunix.graphqldemo.dto.CreateAppSubscriptionInput;

import java.util.List;

public interface AppSubscriptionService {
    /**
     * Returns the list of all app subscriptions for the given customer and status.
     * @param customerId the customerId of the customer
     * @param status    the status of the subscription (-1 - any, 1 - active, 0 - inactive)
     * @return  the list of app subscriptions
     */
    List<AppSubscription> findAllAppSubscriptions(Integer customerId, Integer status);

    /**
     * Updates the details and status of a app subscription
     * @param subscription Updated app subscription details
     * @return  the updated app subscription
     */
    AppSubscription updateAppSubscription(AppSubscription subscription);

    /**
     * Creates new app subscription
     * @param subscription the new app subscription details
     * @return the created app subscription
     */
    AppSubscription createAppSubscription(CreateAppSubscriptionInput subscription);
}
