package com.eaglessoar.simpleconnect.module.seeker.consumer;

import com.eaglessoar.simpleconnect.api.model.ConsumerRequest;
import com.eaglessoar.simpleconnect.api.model.ConsumerResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ConsumerMapper {

    List<ConsumerResponse> toResponse(List<ConsumerDoc> docs);

    ConsumerResponse toResponse(Consumer model);

    Consumer toModel(ConsumerRequest request);

    Consumer toModel(ConsumerDoc doc);

    ConsumerDoc toDoc(Consumer model);
}
