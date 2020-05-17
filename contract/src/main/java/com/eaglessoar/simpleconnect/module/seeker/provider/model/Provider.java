package com.eaglessoar.simpleconnect.module.seeker.provider.model;

import com.eaglessoar.simpleconnect.module.lookup.model.Lookup;
import lombok.Data;

@Data
public class Provider {

    private Long id;
    private String uuid;
    private String name;
    private String currentAddress;
    private String permanentAddress;
    private Lookup provides;
    private String reference;

}
