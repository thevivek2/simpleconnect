package com.eaglessoar.simpleconnect.module.seeker.provider.controller;

import com.eaglessoar.simpleconnect.api.ProviderApiDelegate;
import com.eaglessoar.simpleconnect.api.model.ProviderRequest;
import com.eaglessoar.simpleconnect.api.model.ProviderResponse;
import com.eaglessoar.simpleconnect.api.model.ProviderResponsePage;
import com.eaglessoar.simpleconnect.module.seeker.provider.mapper.ProviderMapper;
import com.eaglessoar.simpleconnect.module.seeker.provider.model.Provider;
import com.eaglessoar.simpleconnect.module.seeker.provider.repository.ProviderJpaRepository;
import com.eaglessoar.simpleconnect.module.seeker.provider.service.ProviderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProviderController implements ProviderApiDelegate {

    private final ProviderService service;
    private final ProviderMapper mapper;
    private final ProviderJpaRepository jpaRepository;

    @Override
    public ResponseEntity<ProviderResponse> providerPost(ProviderRequest providerRequest) {
        Provider provider = mapper.toModel(providerRequest);
        provider.setName("anonymous");
        provider.setCurrentAddress("unknown address");
        return ResponseEntity.ok(mapper.toResponse(service.create(provider)));
    }

    @Override
    public ResponseEntity<ProviderResponsePage> providerGet() {
        return ResponseEntity.ok(new ProviderResponsePage().content(mapper.toResponse(jpaRepository.findAll())));
    }

    @Override
    public ResponseEntity<ProviderResponse> providerUuidGet(String uuid) {
        return ResponseEntity.ok(mapper.toResponse(service.get(uuid)));
    }

    @Override
    public ResponseEntity<ProviderResponse> providerUuidPut(String uuid, ProviderRequest providerRequest) {
        return ResponseEntity.ok(mapper.toResponse(service.update(uuid, mapper.toModel(providerRequest))));
    }
}
