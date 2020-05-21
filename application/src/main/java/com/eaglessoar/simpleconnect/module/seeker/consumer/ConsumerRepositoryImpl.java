package com.eaglessoar.simpleconnect.module.seeker.consumer;

import com.eaglessoar.simpleconnect.exception.ConsumerNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ConsumerRepositoryImpl implements ConsumerRepository {

    private final ConsumerMongoRepository mongoRepository;
    private final ConsumerMapper mapper;

    @Override
    public Consumer findBy(String id) {
        return mapper.toModel(mongoRepository.findById(id).orElseThrow(ConsumerNotFoundException.uuid(id)));
    }

    @Override
    public Consumer save(Consumer consumer) {
        return mapper.toModel(mongoRepository.save(mapper.toDoc(consumer)));
    }
}
