package by.mitr.jmpcloudserviceimpl.service;

import by.mitr.dto.SubscriptionRequestDto;
import by.mitr.dto.SubscriptionResponseDto;
import by.mitr.jmpcloudserviceimpl.mapper.SubscriptionMapper;
import by.mitr.jmpcloudserviceimpl.repository.SubscriptionRepository;

import by.mitr.service.SubscriptionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;
    @Autowired
    private SubscriptionMapper mapper;

    public SubscriptionResponseDto createSubscription(SubscriptionRequestDto subscriptionRequest){

        return mapper.subscriptionToSubscriptionResponseDto(subscriptionRepository.save(mapper.subscriptionRequestDtoToSubscription(subscriptionRequest)));
    }
    public SubscriptionResponseDto updateSubscription(SubscriptionRequestDto subscriptionRequest){

        return mapper.subscriptionToSubscriptionResponseDto(subscriptionRepository.save(mapper.subscriptionRequestDtoToSubscription(subscriptionRequest)));
    }
    public void deleteSubscription(Long subscriptionId){
        subscriptionRepository.deleteById(subscriptionId);
    }
    public SubscriptionResponseDto getSubscription(Long subscriptionId){
        return subscriptionRepository.findById(subscriptionId).map(mapper::subscriptionToSubscriptionResponseDto).get();
    }

    public List<SubscriptionResponseDto> getAllSubscription(){
        return Streamable.of(subscriptionRepository.findAll())
                .map(mapper::subscriptionToSubscriptionResponseDto)
                .toList();
    }
}
