package com.isurunix.graphqldemo.repository;

import com.isurunix.graphqldemo.domain.AppSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppSubscriptionRepository extends JpaRepository<AppSubscription, Long> {
}
