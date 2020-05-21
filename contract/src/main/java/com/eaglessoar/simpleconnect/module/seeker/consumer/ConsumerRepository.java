package com.eaglessoar.simpleconnect.module.seeker.consumer;

public interface ConsumerRepository {

    Consumer findBy(String id);

    Consumer save(Consumer consumer);
}
