package com.eaglessoar.simpleconnect.module.common.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String uuid;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdOn;
}
