package com.eaglessoar.simpleconnect.module.seeker.provider.mapper;

import com.eaglessoar.simpleconnect.api.model.ProviderRequest;
import com.eaglessoar.simpleconnect.api.model.ProviderResponse;
import com.eaglessoar.simpleconnect.module.seeker.provider.model.Provider;
import com.eaglessoar.simpleconnect.module.seeker.provider.repository.ProviderEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProviderMapper {

    Provider toModel(ProviderEntity entity);

    ProviderEntity toEntity(Provider model);

    List<Provider> toModel(List<ProviderEntity> entities);

    Provider toModel(ProviderRequest request);

    ProviderResponse toResponse(Provider model);

    List<ProviderResponse> toResponse(List<ProviderEntity> entities);


}
