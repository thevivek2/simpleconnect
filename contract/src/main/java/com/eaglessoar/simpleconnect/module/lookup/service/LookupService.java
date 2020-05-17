package com.eaglessoar.simpleconnect.module.lookup.service;

import com.eaglessoar.simpleconnect.module.lookup.model.Lookup;

public interface LookupService {

    Lookup create(Lookup lookup);

    Lookup get(String uuid);

    Lookup repair(String uuid, Lookup lookup);

}
