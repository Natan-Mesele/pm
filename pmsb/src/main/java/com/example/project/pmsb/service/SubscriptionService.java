package com.example.project.pmsb.service;

import com.example.project.pmsb.model.PlanType;
import com.example.project.pmsb.model.Subscription;
import com.example.project.pmsb.model.User;

public interface SubscriptionService {

    Subscription createSubscription(User user);
    Subscription getUsersSubscription(Long userId) throws Exception;
    Subscription upgradeSubscription(Long userId, PlanType planType);
    boolean isValid(Subscription subscription);
}
