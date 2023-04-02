package by.mitr.contoller;

import by.mitr.dto.SubscriptionRequestDto;
import by.mitr.dto.SubscriptionResponseDto;

import java.util.List;

public interface  ServiceController {

     SubscriptionResponseDto createSubscription(SubscriptionRequestDto subscriptionRequest);
     SubscriptionResponseDto updateSubscription(SubscriptionRequestDto subscriptionRequest);
     void deleteSubscription(Long subscriptionId);
     SubscriptionResponseDto getSubscription(Long subscriptionId);
     List<SubscriptionResponseDto>  getAllSubscription();
}

