package com.eaglessoar.simpleconnect.module.seeker.provider;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ProviderServiceImpl implements ProviderService {

    private final ProviderRepository repository;

    @Override
    public Provider create(Provider provider) {
        provider.setCreatedOn(LocalDateTime.now());
        return repository.save(provider);
    }

    @Override
    public Provider get(String uuid) {
        return repository.findBy(uuid);
    }

    @Override
    public List<Provider> search(String searchKey) {
        return repository.search(searchKey);
    }

    @Override
    public Provider addNewInterest(String id) {
        Provider by = repository.findBy(id);
        by.setInterestCount(by.getInterestCount() + 1);
        return repository.save(by);
    }


}
