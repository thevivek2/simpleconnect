package com.eaglessoar.simpleconnect.module.seeker.consumer.repository;

import com.eaglessoar.simpleconnect.module.lookup.model.Lookup;
import com.eaglessoar.simpleconnect.module.seeker.consumer.model.Consumer;

import java.util.List;

public interface ConsumerRepository {

    Consumer save(Consumer consumer);

    Consumer findBy(String uuid);

    List<Consumer> simpleMatch(List<Lookup> providerInterests);


}
