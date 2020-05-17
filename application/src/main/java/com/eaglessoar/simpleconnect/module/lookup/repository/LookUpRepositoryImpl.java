package com.eaglessoar.simpleconnect.module.lookup.repository;

import com.eaglessoar.simpleconnect.exception.LookupNotFoundException;
import com.eaglessoar.simpleconnect.module.lookup.mapper.LookupMapper;
import com.eaglessoar.simpleconnect.module.lookup.model.Lookup;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class LookUpRepositoryImpl implements LookupRepository {


    private final LookUpJpaRepository repository;
    private final LookupMapper mapper;

    @Override
    public Lookup save(Lookup lookup) {
        return mapper.toModel(repository.save(mapper.toEntity(lookup)));
    }

    @Override
    public Lookup findBy(String uuid) {
        return mapper.toModel(repository.findByUuid(uuid).orElseThrow(LookupNotFoundException.uuid(uuid)));
    }

}
