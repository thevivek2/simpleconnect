package com.eaglessoar.simpleconnect.module.seeker.consumer;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConsumerMongoRepository extends MongoRepository<ConsumerDoc, String> {

}
