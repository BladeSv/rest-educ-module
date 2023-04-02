package by.mitr.jmpcloudserviceimpl.mapper;

import by.mitr.dto.SubscriptionRequestDto;
import by.mitr.dto.SubscriptionResponseDto;
import by.mitr.jmpcloudserviceimpl.repository.UserRepository;
import by.mitr.model.Subscription;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class SubscriptionMapper {

    @Autowired
    protected UserRepository userRepository;

    @Mapping(target="userId", source = "user.id")
    public abstract SubscriptionResponseDto subscriptionToSubscriptionResponseDto(Subscription subscription);


    @Mapping(target = "user", expression = "java(userRepository.findById(subscriptionRequestDto.getUserId()).get())")
    @Mapping(target = "startDate", expression = "java(java.time.LocalDate.now())")
    public abstract Subscription  subscriptionRequestDtoToSubscription(SubscriptionRequestDto subscriptionRequestDto);


}
