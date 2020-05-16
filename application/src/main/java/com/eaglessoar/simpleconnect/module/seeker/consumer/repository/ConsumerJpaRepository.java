package com.eaglessoar.simpleconnect.module.seeker.consumer.repository;

import com.eaglessoar.simpleconnect.module.lookup.repository.entity.LookupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ConsumerJpaRepository extends JpaRepository<ConsumerEntity, Long> {

    Optional<ConsumerEntity> findByUuid(String uuid);

    List<ConsumerEntity> findByConsumesIn(List<LookupEntity> providerInterests);

}
