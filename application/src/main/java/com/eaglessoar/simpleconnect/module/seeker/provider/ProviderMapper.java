package com.eaglessoar.simpleconnect.module.seeker.provider;

import com.eaglessoar.simpleconnect.api.model.ProviderRequest;
import com.eaglessoar.simpleconnect.api.model.ProviderResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProviderMapper {

    Provider toModel(ProviderRequest request);

    ProviderResponse toResponse(Provider model);

    List<ProviderResponse> toResponse(List<ProviderDoc> docs);

    Provider toModel(ProviderDoc doc);

    ProviderDoc toDoc(Provider model);

    List<Provider> toModel(List<ProviderDoc> docs);

    List<ProviderResponse> map(List<Provider> docs);
}
