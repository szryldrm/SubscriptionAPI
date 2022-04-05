package com.kalia.network.subscriptionapi.repository;

import com.kalia.network.subscriptionapi.core.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriberRepository extends JpaRepository<Subscriber, Integer> {
}