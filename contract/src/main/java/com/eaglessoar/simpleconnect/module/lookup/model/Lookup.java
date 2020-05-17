package com.eaglessoar.simpleconnect.module.lookup.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Lookup {

    private Long id;
    private String uuid;
    private String summary;
    private String description;
    private LocalDateTime createdOn;
}
