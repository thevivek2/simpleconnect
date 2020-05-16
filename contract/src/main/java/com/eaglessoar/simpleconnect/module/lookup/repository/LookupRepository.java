package com.eaglessoar.simpleconnect.module.lookup.repository;

import com.eaglessoar.simpleconnect.module.lookup.model.Lookup;

public interface LookupRepository {

    Lookup save(Lookup interestedReason);

    Lookup findBy(String uuid);

    boolean existsByCode(String code);

    boolean existsByCodeAndUuidNot(String code, String uuid);

    Lookup findByCode(String code);


}
