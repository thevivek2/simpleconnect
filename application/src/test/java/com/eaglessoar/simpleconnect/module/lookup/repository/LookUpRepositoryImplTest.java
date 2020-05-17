package com.eaglessoar.simpleconnect.module.lookup.repository;

import com.eaglessoar.simpleconnect.exception.LookupNotFoundException;
import com.eaglessoar.simpleconnect.module.lookup.mapper.LookupMapper;
import com.eaglessoar.simpleconnect.module.lookup.model.Lookup;
import com.eaglessoar.simpleconnect.module.lookup.repository.entity.LookupEntity;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class LookUpRepositoryImplTest {

    private LookUpJpaRepository jpaRepository;
    private LookupMapper mapper;
    private LookupRepository repository;


    @Before
    public void setUp() {
        jpaRepository = mock(LookUpJpaRepository.class);
        mapper = mock(LookupMapper.class);
        repository = new LookUpRepositoryImpl(jpaRepository, mapper);
    }

    @Test
    public void save() {
        Lookup lookup = new Lookup();
        LookupEntity entity = new LookupEntity();
        when(mapper.toEntity(lookup)).thenReturn(entity);
        when(jpaRepository.save(entity)).thenReturn(entity);
        when(mapper.toModel(entity)).thenReturn(lookup);

        assertThat(repository.save(lookup)).isEqualTo(lookup);
        verify(mapper).toEntity(lookup);
        verify(mapper).toModel(entity);
        verify(jpaRepository).save(entity);

    }

    @Test
    public void findByUuidWhenItemExistsShouldReturnItem() {
        String uuid = "2";
        LookupEntity entity = entity(uuid);
        Lookup lookup = new Lookup();
        when(jpaRepository.findByUuid(uuid)).thenReturn(Optional.of(entity));
        when(mapper.toModel(entity)).thenReturn(lookup);

        assertThat(repository.findBy(uuid)).isEqualTo(lookup);
    }

    @Test(expected = LookupNotFoundException.class)
    public void findByUuidWhenItemNotExistsShouldRaiseException() {
        String uuid = "2";
        when(jpaRepository.findByUuid(uuid)).thenReturn(Optional.empty());
        repository.findBy(uuid);
        verify(jpaRepository).findByUuid(uuid);
    }


    private static LookupEntity entity(String uuid) {
        LookupEntity entity = new LookupEntity();
        entity.setUuid(uuid);
        return entity;
    }
}