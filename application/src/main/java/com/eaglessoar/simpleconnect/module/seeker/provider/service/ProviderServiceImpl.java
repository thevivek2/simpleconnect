package com.eaglessoar.simpleconnect.module.seeker.provider.service;

import com.eaglessoar.simpleconnect.module.lookup.model.Lookup;
import com.eaglessoar.simpleconnect.module.lookup.service.LookupService;
import com.eaglessoar.simpleconnect.module.seeker.provider.model.Provider;
import com.eaglessoar.simpleconnect.module.seeker.provider.repository.ProviderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProviderServiceImpl implements ProviderService {

    private final ProviderRepository repository;

    @Override
    public Provider create(Provider provider) {
        provider.setUuid(UUID.randomUUID().toString());
        return repository.save(provider);
    }

    @Override
    public Provider get(String uuid) {
        return repository.findBy(uuid);
    }

    @Override
    public Provider update(String uuid, Provider provider) {
        Provider onSystem = repository.findBy(uuid);
        provider.setUuid(uuid);
        provider.setId(onSystem.getId());
        return repository.save(provider);
    }

    @Override
    public List<Provider> getBestFitProviders(List<Lookup> consumerInterest) {
        return repository.simpleMatch(consumerInterest);
    }

}
