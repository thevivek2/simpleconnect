package com.eaglessoar.simpleconnect.module.lookup.repository;


import com.eaglessoar.simpleconnect.module.lookup.repository.entity.LookupEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
public class LookupJpaRepositoryITest {

    private static final String UUID = "2";
    private static final String CODE = "002";

    @Autowired
    private LookUpJpaRepository jpaRepository;


    @Before
    public void setUp() {
        jpaRepository.save(entity());
    }

    @Test
    public void findByUuid() {
        Optional<LookupEntity> byUuid = jpaRepository.findByUuid(UUID);
        assertThat(byUuid.get().getCode()).isEqualTo(CODE);
    }


    private static LookupEntity entity() {
        LookupEntity entity = new LookupEntity();
        entity.setUuid(UUID);
        entity.setCode(CODE);
        entity.setCategory("REMOTE WORK");
        entity.setDescription("Deliver the existing skills and platform to grow more");
        entity.setAdditionalInfo("N/A");
        return entity;
    }

}