package com.eaglessoar.simpleconnect.module.seeker.consumer.controller;

import com.eaglessoar.simpleconnect.api.ConsumerApiDelegate;
import com.eaglessoar.simpleconnect.api.model.ConsumerRequest;
import com.eaglessoar.simpleconnect.api.model.ConsumerResponse;
import com.eaglessoar.simpleconnect.api.model.ConsumerResponsePage;
import com.eaglessoar.simpleconnect.module.seeker.consumer.mapper.ConsumerMapper;
import com.eaglessoar.simpleconnect.module.seeker.consumer.repository.ConsumerJpaRepository;
import com.eaglessoar.simpleconnect.module.seeker.consumer.service.ConsumerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ConsumerController implements ConsumerApiDelegate {

    private final ConsumerService service;
    private final ConsumerMapper mapper;
    private final ConsumerJpaRepository repository;


    @Override
    public ResponseEntity<ConsumerResponse> consumerPost(ConsumerRequest consumerRequest) {
        return ResponseEntity.ok(mapper.toResponse(service.create(mapper.toModel(consumerRequest))));
    }

    @Override
    public ResponseEntity<ConsumerResponsePage> consumerGet() {
        return ResponseEntity.ok(new ConsumerResponsePage().content(mapper.toResponse(repository.findAll())));
    }

    @Override
    public ResponseEntity<ConsumerResponse> consumerUuidGet(String uuid) {
        return ResponseEntity.ok(mapper.toResponse(service.get(uuid)));
    }

    @Override
    public ResponseEntity<ConsumerResponse> consumerUuidPut(String uuid, ConsumerRequest consumerRequest) {
        return ResponseEntity.ok(mapper.toResponse(service.update(uuid, mapper.toModel(consumerRequest))));
    }
}
