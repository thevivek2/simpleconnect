package com.eaglessoar.simpleconnect.module.lookup.repository;

import com.eaglessoar.simpleconnect.module.lookup.model.Lookup;

public interface LookupRepository {

    Lookup save(Lookup interestedReason);

    Lookup findBy(String uuid);

}
