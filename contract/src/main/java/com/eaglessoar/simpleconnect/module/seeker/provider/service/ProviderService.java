package com.eaglessoar.simpleconnect.module.seeker.provider.service;

import com.eaglessoar.simpleconnect.module.lookup.model.Lookup;
import com.eaglessoar.simpleconnect.module.seeker.provider.model.Provider;

import java.util.List;

public interface ProviderService {

    Provider create(Provider provider);

    Provider get(String uuid);

    Provider update(String uuid, Provider provider);

    List<Provider> getBestFitProviders(List<Lookup> consumerInterest);
}
