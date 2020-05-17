package com.eaglessoar.simpleconnect.module.lookup.repository.entity;

import com.eaglessoar.simpleconnect.module.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class LookupEntity extends BaseEntity {

    @Column(nullable = false)
    private String summary;
    @Lob
    @Column(nullable = false)
    private String description;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdOn;
}
