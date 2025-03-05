package com.rest.controller;

import com.rest.cloudserviceimpl.service.ServiceServiceImpl;
import com.rest.dto.dto.SubscriptionRequestDto;
import com.rest.dto.dto.SubscriptionResponseDto;
import com.rest.modelassempler.ServiceAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/subscriptions")
@RequiredArgsConstructor
public class ServiceController {

    private final ServiceServiceImpl serviceService;
    private final ServiceAssembler serviceAssembler;

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<SubscriptionResponseDto>>> getAllSubscription() {
        return ResponseEntity.ok(serviceAssembler.toCollectionModel(serviceService.getAllSubscription()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<SubscriptionResponseDto>> getSubscription(@PathVariable("id") Long subscriptionId) {
        SubscriptionResponseDto subscriptionResponseDto = serviceService.getSubscription(subscriptionId);
        EntityModel<SubscriptionResponseDto> subscriptionResponseDtoEntityModel = serviceAssembler.toModel(subscriptionResponseDto);
        return ResponseEntity.ok(subscriptionResponseDtoEntityModel);
    }

    @PostMapping
    public ResponseEntity<EntityModel<SubscriptionResponseDto>> createSubscription(@RequestBody SubscriptionRequestDto subscriptionRequestDto) {
        SubscriptionResponseDto subscriptionResponseDto = serviceService.createSubscription(subscriptionRequestDto);
        EntityModel<SubscriptionResponseDto> subscriptionResponseDtoEntityModel = serviceAssembler.toModel(subscriptionResponseDto);
        return ResponseEntity.ok(subscriptionResponseDtoEntityModel);
    }

    @PutMapping
    public ResponseEntity<EntityModel<SubscriptionResponseDto>> updateSubscription(@RequestBody SubscriptionRequestDto subscriptionRequestDto) {
        SubscriptionResponseDto subscriptionResponseDto = serviceService.updateSubscription(subscriptionRequestDto);
        EntityModel<SubscriptionResponseDto> subscriptionResponseDtoEntityModel = serviceAssembler.toModel(subscriptionResponseDto);
        return ResponseEntity.ok(subscriptionResponseDtoEntityModel);
    }

    @DeleteMapping("/{id}")
    public boolean deleteSubscription(@PathVariable("id") Long subscriptionId) {
        return serviceService.deleteSubscription(subscriptionId);
    }

}
