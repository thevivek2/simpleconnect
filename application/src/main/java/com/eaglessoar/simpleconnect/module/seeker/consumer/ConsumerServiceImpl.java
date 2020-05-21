package com.eaglessoar.simpleconnect.module.seeker.consumer;

import com.eaglessoar.simpleconnect.module.seeker.provider.ProviderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConsumerServiceImpl implements ConsumerService {

    private final ConsumerRepository repository;
    private final ProviderService providerService;

    @Override
    public Consumer create(Consumer consumer) {
        providerService.addNewInterest(consumer.getConsumes());
        return repository.save(consumer);
    }

    @Override
    public Consumer get(String id) {
        return repository.findBy(id);
    }


}
