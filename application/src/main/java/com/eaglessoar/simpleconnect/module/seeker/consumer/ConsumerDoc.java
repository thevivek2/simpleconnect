package com.eaglessoar.simpleconnect.module.seeker.consumer;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class ConsumerDoc {

    @Id
    private String id;
    private String name;
    private String address;
    private String reference;
    private String consumes;
    private String createdOn;

}
