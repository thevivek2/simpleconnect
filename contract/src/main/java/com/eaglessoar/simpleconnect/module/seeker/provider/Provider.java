package com.eaglessoar.simpleconnect.module.seeker.provider;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Provider {

    private String id;
    private String name;
    private String address;
    private String reference;
    private String summary;
    private String description;
    private Float score;
    private LocalDateTime createdOn;
    private int interestCount;
}
