package com.eaglessoar.simpleconnect.module.seeker.provider.repository;

import com.eaglessoar.simpleconnect.module.lookup.repository.entity.LookupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProviderJpaRepository extends JpaRepository<ProviderEntity, Long> {

    Optional<ProviderEntity> findByUuid(String uuid);

    List<ProviderEntity> findByProvidesIn(List<LookupEntity> consumerInterests);
}
