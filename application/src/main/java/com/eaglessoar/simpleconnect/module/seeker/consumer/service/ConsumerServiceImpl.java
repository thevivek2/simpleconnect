package com.eaglessoar.simpleconnect.module.seeker.consumer.service;

import com.eaglessoar.simpleconnect.module.lookup.model.Lookup;
import com.eaglessoar.simpleconnect.module.lookup.service.LookupService;
import com.eaglessoar.simpleconnect.module.seeker.consumer.model.Consumer;
import com.eaglessoar.simpleconnect.module.seeker.consumer.repository.ConsumerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ConsumerServiceImpl implements ConsumerService {

    private final ConsumerRepository repository;
    private final LookupService lookupService;

    @Override
    public Consumer create(Consumer consumer) {
        consumer.setUuid(UUID.randomUUID().toString());
        Lookup lookup = lookupService.get(consumer.getConsumes().getUuid());
        lookup.setInterestedCount(lookup.getInterestedCount() + 1);
        consumer.setConsumes(lookupService.save(lookup));
        return repository.save(consumer);
    }

    @Override
    public Consumer get(String uuid) {
        return repository.findBy(uuid);
    }

    @Override
    public Consumer update(String uuid, Consumer consumer) {
        Consumer onSystem = repository.findBy(uuid);
        consumer.setUuid(uuid);
        consumer.setId(onSystem.getId());
        consumer.setConsumes(lookupService.get(consumer.getConsumes().getUuid()));
        return repository.save(consumer);
    }

    @Override
    public List<Consumer> getBestFitConsumers(List<Lookup> providerInterest) {
        return repository.simpleMatch(providerInterest);
    }

}
