package com.eaglessoar.simpleconnect.module.seeker.consumer.model;

import com.eaglessoar.simpleconnect.module.lookup.model.Lookup;
import lombok.Data;

@Data
public class Consumer {

    private Long id;
    private String uuid;
    private String name;
    private String address;
    private Lookup consumes;
    private String reference;


}
