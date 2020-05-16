package com.eaglessoar.simpleconnect.module.seeker.provider.repository;

import com.eaglessoar.simpleconnect.module.lookup.model.Lookup;
import com.eaglessoar.simpleconnect.module.seeker.provider.model.Provider;

import java.util.List;

public interface ProviderRepository {

    Provider save(Provider consumer);

    Provider findBy(String uuid);

    List<Provider> simpleMatch(List<Lookup> consumerInterests);

}
