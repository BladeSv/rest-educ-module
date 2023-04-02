package by.mitr.jmpcloudserviceimpl.controller;



import by.mitr.contoller.ServiceController;
import by.mitr.dto.SubscriptionRequestDto;
import by.mitr.dto.SubscriptionResponseDto;

import by.mitr.dto.UserResponseDto;
import by.mitr.service.SubscriptionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/service")
@AllArgsConstructor
public class ServiceControllerImpl implements ServiceController {

    @Autowired
    private SubscriptionService subscriptionService;

    @PostMapping
    @Override
    public SubscriptionResponseDto createSubscription(@RequestBody SubscriptionRequestDto subscriptionRequest) {

        return addHATEOAS(subscriptionService.createSubscription(subscriptionRequest));
    }
    @PutMapping
    @Override
    public SubscriptionResponseDto updateSubscription(@RequestBody SubscriptionRequestDto subscriptionRequest) {

        return addHATEOAS(subscriptionService.updateSubscription(subscriptionRequest));
    }
    @DeleteMapping("/{id}")
    @Override
    public void deleteSubscription(@PathVariable("id") Long subscriptionId) {
        subscriptionService.deleteSubscription(subscriptionId);
    }
    @GetMapping("/{id}")
    @Override
    public SubscriptionResponseDto getSubscription(@PathVariable("id") Long subscriptionId) {
        return addHATEOAS(subscriptionService.getSubscription(subscriptionId));
    }

    @GetMapping
    @Override
    public List<SubscriptionResponseDto> getAllSubscription() {
        return subscriptionService.getAllSubscription().stream()
                .map(this::addHATEOAS)
                .toList();
    }

    private SubscriptionResponseDto addHATEOAS(SubscriptionResponseDto dto){
        dto.add(linkTo(methodOn(ServiceControllerImpl.class).getSubscription(dto.getId())).withSelfRel());
        dto.add(linkTo(methodOn(ServiceControllerImpl.class).getAllSubscription()).withRel(IanaLinkRelations.COLLECTION));
        return dto;
    }
}
