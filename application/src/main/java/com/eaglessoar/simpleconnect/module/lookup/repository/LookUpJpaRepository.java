package com.eaglessoar.simpleconnect.module.lookup.repository;

import com.eaglessoar.simpleconnect.module.lookup.repository.entity.LookupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LookUpJpaRepository extends JpaRepository<LookupEntity, Long> {

    Optional<LookupEntity> findByUuid(String uuid);

    boolean existsByCode(String code);

    boolean existsByCodeAndUuidNot(String code, String uuid);

    Optional<LookupEntity> findByCode(String code);
}
