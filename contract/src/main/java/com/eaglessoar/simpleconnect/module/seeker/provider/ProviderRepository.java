package com.eaglessoar.simpleconnect.module.seeker.provider;

import java.util.List;

public interface ProviderRepository {

    Provider findBy(String id);
    Provider save(Provider provider);
    List<Provider> search(String searchKey);
}
