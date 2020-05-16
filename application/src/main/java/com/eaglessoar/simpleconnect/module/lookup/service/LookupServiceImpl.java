package com.eaglessoar.simpleconnect.module.lookup.service;

import com.eaglessoar.simpleconnect.exception.DuplicateLookupException;
import com.eaglessoar.simpleconnect.module.lookup.model.Lookup;
import com.eaglessoar.simpleconnect.module.lookup.repository.LookupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class LookupServiceImpl implements LookupService {

    private final LookupRepository repository;

    @Override
    public Lookup create(Lookup lookup) {
        if (repository.existsByCode(lookup.getCode()))
            throw DuplicateLookupException.code(lookup.getCode()).get();
        lookup.setUuid(UUID.randomUUID().toString());
        return repository.save(lookup);
    }

    @Override
    public Lookup get(String uuid) {
        return repository.findBy(uuid);
    }

    @Override
    public Lookup repair(String uuid, Lookup lookup) {
        if (repository.existsByCodeAndUuidNot(lookup.getCode(), uuid))
            throw DuplicateLookupException.code(lookup.getCode()).get();
        Lookup onSystem = repository.findBy(uuid);
        lookup.setId(onSystem.getId());
        lookup.setUuid(onSystem.getUuid());
        return repository.save(lookup);
    }

    @Override
    public Lookup getByCode(String code) {
        return repository.findByCode(code);
    }


}
