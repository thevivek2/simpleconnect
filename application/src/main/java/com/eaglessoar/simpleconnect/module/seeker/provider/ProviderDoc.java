package com.eaglessoar.simpleconnect.module.seeker.provider;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.TextScore;

import java.time.LocalDateTime;

@Data
@Document
public class ProviderDoc {

    @Id
    private String id;
    private String name;
    private String address;
    private String reference;
    @TextIndexed
    private String summary;
    @TextIndexed
    private String description;
    private LocalDateTime createdOn;
    @TextScore
    private Float score;
    private int interestCount;

}
