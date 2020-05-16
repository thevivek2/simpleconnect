package com.eaglessoar.simpleconnect.module.lookup.controller;

import com.eaglessoar.simpleconnect.api.LookupApiDelegate;
import com.eaglessoar.simpleconnect.api.model.LookupRequest;
import com.eaglessoar.simpleconnect.api.model.LookupResponse;
import com.eaglessoar.simpleconnect.api.model.LookupResponsePage;
import com.eaglessoar.simpleconnect.module.lookup.mapper.LookupMapper;
import com.eaglessoar.simpleconnect.module.lookup.repository.LookUpJpaRepository;
import com.eaglessoar.simpleconnect.module.lookup.service.LookupService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class LookUpController implements LookupApiDelegate {

    private final LookupService service;
    private final LookupMapper mapper;
    private final LookUpJpaRepository jpaRepository;

    @Override
    public ResponseEntity<LookupResponse> lookupPost(LookupRequest lookupRequest) {
        return ResponseEntity.ok(mapper.toResponse(service.create(mapper.toModel(lookupRequest))));
    }

    @Override
    public ResponseEntity<LookupResponsePage> lookupGet() {
        return ResponseEntity.ok(new LookupResponsePage().content(jpaRepository.findAll().stream().map(mapper::toResponse).collect(Collectors.toList())));
    }

    @Override
    public ResponseEntity<LookupResponse> lookupUuidGet(String uuid) {
        return ResponseEntity.ok(mapper.toResponse(service.get(uuid)));
    }

    @Override
    public ResponseEntity<LookupResponse> lookupUuidPut(String uuid, LookupRequest lookupRequest) {
        return ResponseEntity.ok(mapper.toResponse(service.repair(uuid, mapper.toModel(lookupRequest))));
    }
}
