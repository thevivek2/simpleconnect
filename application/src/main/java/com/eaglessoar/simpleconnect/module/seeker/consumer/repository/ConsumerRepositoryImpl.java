package com.eaglessoar.simpleconnect.module.seeker.consumer.repository;

import com.eaglessoar.simpleconnect.exception.ConsumerNotFoundException;
import com.eaglessoar.simpleconnect.module.lookup.mapper.LookupMapper;
import com.eaglessoar.simpleconnect.module.lookup.model.Lookup;
import com.eaglessoar.simpleconnect.module.seeker.consumer.mapper.ConsumerMapper;
import com.eaglessoar.simpleconnect.module.seeker.consumer.model.Consumer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ConsumerRepositoryImpl implements ConsumerRepository {

    private final ConsumerJpaRepository jpaRepository;
    private final ConsumerMapper mapper;
    private final LookupMapper lookupMapper;


    @Override
    public Consumer save(Consumer consumer) {
        return mapper.toModel(jpaRepository.save(mapper.toEntity(consumer)));
    }

    @Override
    public Consumer findBy(String uuid) {
        return mapper.toModel(jpaRepository.findByUuid(uuid).orElseThrow(ConsumerNotFoundException.uuid(uuid)));
    }

    @Override
    public List<Consumer> simpleMatch(List<Lookup> providerInterests) {
        return mapper.toModel(jpaRepository.findByConsumesIn(lookupMapper.toEntity(providerInterests)));
    }


}
