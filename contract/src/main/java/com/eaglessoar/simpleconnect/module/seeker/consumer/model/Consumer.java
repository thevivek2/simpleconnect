package com.eaglessoar.simpleconnect.module.seeker.consumer.model;

import com.eaglessoar.simpleconnect.module.lookup.model.Lookup;
import lombok.Data;

import java.util.List;

@Data
public class Consumer {

    private Long id;
    private String uuid;
    private String name;
    private String address;
    private List<Lookup> consumes;
    private String reference;


}
