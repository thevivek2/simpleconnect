package com.eaglessoar.simpleconnect.module.seeker.provider.repository;

import com.eaglessoar.simpleconnect.exception.ProviderNotFoundException;
import com.eaglessoar.simpleconnect.module.lookup.mapper.LookupMapper;
import com.eaglessoar.simpleconnect.module.lookup.model.Lookup;
import com.eaglessoar.simpleconnect.module.seeker.provider.mapper.ProviderMapper;
import com.eaglessoar.simpleconnect.module.seeker.provider.model.Provider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ProviderRepositoryImpl implements ProviderRepository {

    private final ProviderJpaRepository jpaRepository;
    private final ProviderMapper mapper;
    private final LookupMapper lookupMapper;

    @Override
    public Provider save(Provider provider) {
        return mapper.toModel(jpaRepository.save(mapper.toEntity(provider)));
    }

    @Override
    public Provider findBy(String uuid) {
        return mapper.toModel(jpaRepository.findByUuid(uuid).orElseThrow(ProviderNotFoundException.uuid(uuid)));
    }

    @Override
    public List<Provider> simpleMatch(List<Lookup> consumerInterests) {
        return mapper.toModel(jpaRepository.findByProvidesIn(lookupMapper.toEntity(consumerInterests)));
    }
}
