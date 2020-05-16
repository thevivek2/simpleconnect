package com.eaglessoar.simpleconnect.module.lookup.repository.entity;

import com.eaglessoar.simpleconnect.module.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class LookupEntity extends BaseEntity {

    @Column(nullable = false)
    private String category;
    @Column(nullable = false, unique = true)
    private String code;
    @Column(nullable = false)
    private String description;
    private String additionalInfo;
}
