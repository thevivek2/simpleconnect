package com.eaglessoar.simpleconnect.module.seeker.consumer.mapper;

import com.eaglessoar.simpleconnect.api.model.ConsumerRequest;
import com.eaglessoar.simpleconnect.api.model.ConsumerResponse;
import com.eaglessoar.simpleconnect.module.seeker.consumer.model.Consumer;
import com.eaglessoar.simpleconnect.module.seeker.consumer.repository.ConsumerEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ConsumerMapper {

    Consumer toModel(ConsumerEntity entity);
    ConsumerEntity toEntity(Consumer model);
    List<Consumer> toModel(List<ConsumerEntity> entities);

    ConsumerResponse toResponse(Consumer model);
    Consumer toModel(ConsumerRequest request);

    List<ConsumerResponse> toResponse(List<ConsumerEntity> entities);


}
