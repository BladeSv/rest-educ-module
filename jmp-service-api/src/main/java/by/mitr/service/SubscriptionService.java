package by.mitr.service;

import by.mitr.dto.SubscriptionRequestDto;
import by.mitr.dto.SubscriptionResponseDto;

import java.util.List;

public interface SubscriptionService {


    SubscriptionResponseDto createSubscription(SubscriptionRequestDto subscriptionRequest);
     SubscriptionResponseDto updateSubscription(SubscriptionRequestDto subscriptionRequest);
     void deleteSubscription(Long subscriptionId);
     SubscriptionResponseDto getSubscription(Long subscriptionId);
    public List<SubscriptionResponseDto> getAllSubscription();
}
