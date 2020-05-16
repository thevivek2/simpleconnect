package com.eaglessoar.simpleconnect.module.lookup.mapper;

import com.eaglessoar.simpleconnect.api.model.LookupRequest;
import com.eaglessoar.simpleconnect.api.model.LookupResponse;
import com.eaglessoar.simpleconnect.module.lookup.model.Lookup;
import com.eaglessoar.simpleconnect.module.lookup.repository.entity.LookupEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LookupMapper {

    LookupEntity toEntity(Lookup model);

    Lookup toModel(LookupEntity entity);

    LookupResponse toResponse(LookupEntity entity);

    Lookup toModel(LookupRequest request);

    LookupResponse toResponse(Lookup model);

    List<LookupEntity> toEntity(List<Lookup> lookups);


}
