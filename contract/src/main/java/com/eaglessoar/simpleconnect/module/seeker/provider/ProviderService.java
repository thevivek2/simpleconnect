package com.eaglessoar.simpleconnect.module.seeker.provider;

import java.util.List;

public interface ProviderService {

    Provider create(Provider provider);

    Provider get(String id);

    List<Provider> search(String searchKey);

    Provider addNewInterest(String id);

}
