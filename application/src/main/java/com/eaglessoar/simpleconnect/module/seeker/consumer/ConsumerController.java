package com.eaglessoar.simpleconnect.module.seeker.consumer;

import com.eaglessoar.simpleconnect.api.ConsumerApi;
import com.eaglessoar.simpleconnect.api.model.ConsumerRequest;
import com.eaglessoar.simpleconnect.api.model.ConsumerResponse;
import com.eaglessoar.simpleconnect.api.model.ConsumerResponsePage;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ConsumerController implements ConsumerApi {

    private final ConsumerService service;
    private final ConsumerMapper mapper;
    private final ConsumerMongoRepository repository;


    @Override
    public ResponseEntity<ConsumerResponse> consumerPost(ConsumerRequest consumerRequest) {
        Consumer consumer = mapper.toModel(consumerRequest);
        consumer.setName("anonymous 2");
        return ResponseEntity.ok(mapper.toResponse(service.create(consumer)));
    }

    @Override
    public ResponseEntity<ConsumerResponsePage> consumerGet() {
        return ResponseEntity.ok(new ConsumerResponsePage().content(mapper.toResponse(repository.findAll())));
    }

    @Override
    public ResponseEntity<ConsumerResponse> consumerUuidGet(String uuid) {
        return ResponseEntity.ok(mapper.toResponse(service.get(uuid)));
    }

    @Override
    public ResponseEntity<ConsumerResponse> consumerUuidPut(String uuid, ConsumerRequest consumerRequest) {
        return null;
    }
}
