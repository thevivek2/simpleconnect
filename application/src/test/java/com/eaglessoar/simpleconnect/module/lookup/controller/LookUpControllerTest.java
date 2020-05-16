package com.eaglessoar.simpleconnect.module.lookup.controller;

import com.eaglessoar.simpleconnect.api.model.LookupRequest;
import com.eaglessoar.simpleconnect.api.model.LookupResponse;
import com.eaglessoar.simpleconnect.api.model.LookupResponsePage;
import com.eaglessoar.simpleconnect.module.lookup.mapper.LookupMapper;
import com.eaglessoar.simpleconnect.module.lookup.model.Lookup;
import com.eaglessoar.simpleconnect.module.lookup.repository.LookUpJpaRepository;
import com.eaglessoar.simpleconnect.module.lookup.repository.entity.LookupEntity;
import com.eaglessoar.simpleconnect.module.lookup.service.LookupService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static java.util.Objects.requireNonNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.OK;

@RunWith(MockitoJUnitRunner.class)
public class LookUpControllerTest {

    @Mock
    private LookupService service;
    @Mock
    private LookupMapper mapper;
    @Mock
    private LookUpJpaRepository jpaRepository;

    private LookUpController controller;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        controller = new LookUpController(service, mapper, jpaRepository);
    }

    @Test
    public void lookupPost() {
        String uuid = "2";
        LookupRequest request = new LookupRequest();
        LookupResponse response = response(uuid);
        Lookup lookup = new Lookup();
        when(mapper.toModel(request)).thenReturn(lookup);
        when(mapper.toResponse(lookup)).thenReturn(response);
        when(service.create(lookup)).thenReturn(lookup);

        ResponseEntity<LookupResponse> responseEntity = controller.lookupPost(request);

        assertThat(responseEntity.getStatusCode()).isEqualTo(OK);
        assertThat(requireNonNull(responseEntity.getBody()).getUuid()).isEqualTo(uuid);
        verify(mapper).toModel(request);
        verify(mapper).toResponse(lookup);
        verify(service).create(lookup);
    }

    @Test
    public void lookupGet() {
        String uuid = "2";
        LookupResponse response = response(uuid);
        when(jpaRepository.findAll()).thenReturn(Arrays.asList(new LookupEntity(), new LookupEntity()));
        when(mapper.toResponse(any(LookupEntity.class))).thenReturn(response);

        ResponseEntity<LookupResponsePage> responseEntity = controller.lookupGet();

        assertThat(responseEntity.getStatusCode()).isEqualTo(OK);
        assertThat(requireNonNull(responseEntity.getBody()).getContent().size()).isEqualTo(2);
        verify(jpaRepository).findAll();
    }

    @Test
    public void lookupUuidGet() {
        String uuid = "2";
        String code = "002";
        LookupResponse response = response(uuid, code);
        Lookup lookup = new Lookup();
        when(mapper.toResponse(lookup)).thenReturn(response);
        when(service.get(uuid)).thenReturn(lookup);

        ResponseEntity<LookupResponse> responseEntity = controller.lookupUuidGet(uuid);

        assertThat(responseEntity.getStatusCode()).isEqualTo(OK);
        assertThat(requireNonNull(responseEntity.getBody()).getCode()).isEqualTo(code);
        verify(mapper).toResponse(lookup);
        verify(service).get(uuid);
    }

    @Test
    public void lookupUuidPut() {
        String uuid = "2";
        String code = "002";
        LookupRequest request = new LookupRequest();
        LookupResponse response = response(uuid, code);
        Lookup lookup = new Lookup();
        when(mapper.toModel(request)).thenReturn(lookup);
        when(mapper.toResponse(lookup)).thenReturn(response);
        when(service.repair(uuid, lookup)).thenReturn(lookup);

        ResponseEntity<LookupResponse> responseEntity = controller.lookupUuidPut(uuid, request);

        assertThat(responseEntity.getStatusCode()).isEqualTo(OK);
        assertThat(requireNonNull(responseEntity.getBody()).getCode()).isEqualTo(code);
        verify(mapper).toModel(request);
        verify(mapper).toResponse(lookup);
        verify(service).repair(uuid, lookup);
    }


    private static LookupResponse response(String uuid) {
        LookupResponse response = new LookupResponse();
        response.setUuid(uuid);
        return response;
    }

    private static LookupResponse response(String uuid, String code) {
        LookupResponse response = response(uuid);
        response.setCode(code);
        return response;
    }
}