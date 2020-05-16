package com.eaglessoar.simpleconnect.module.seeker.consumer.service;

import com.eaglessoar.simpleconnect.module.lookup.model.Lookup;
import com.eaglessoar.simpleconnect.module.seeker.consumer.model.Consumer;

import java.util.List;

public interface ConsumerService {

    Consumer create(Consumer consumer);

    Consumer get(String uuid);

    Consumer update(String uuid, Consumer consumer);

    List<Consumer> getBestFitConsumers(List<Lookup> providerInterest);

}
