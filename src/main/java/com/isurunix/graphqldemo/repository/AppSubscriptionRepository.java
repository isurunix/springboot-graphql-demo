package com.isurunix.graphqldemo.repository;

import com.isurunix.graphqldemo.domain.AppSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppSubscriptionRepository extends JpaRepository<AppSubscription, Long> {

    @Query("from AppSubscription a where a.customer.customerCode=:customerCode and " +
            ":status = -1 or (:status <> -1 and a.status=:status)")
    List<AppSubscription> findAllByCustomerCodeAndStatus(@Param("customerCode") Integer customerCode,
                                                         @Param("status") Integer status);
}
