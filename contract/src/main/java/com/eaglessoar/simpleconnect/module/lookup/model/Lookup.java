package com.eaglessoar.simpleconnect.module.lookup.model;

import lombok.Data;

@Data
public class Lookup {

    private Long id;
    private String uuid;
    private String category;
    private String code;
    private String description;
    private String additionalInfo;
}
