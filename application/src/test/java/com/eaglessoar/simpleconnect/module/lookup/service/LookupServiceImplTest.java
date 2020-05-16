package com.eaglessoar.simpleconnect.module.lookup.service;

import com.eaglessoar.simpleconnect.exception.DuplicateLookupException;
import com.eaglessoar.simpleconnect.module.lookup.model.Lookup;
import com.eaglessoar.simpleconnect.module.lookup.repository.LookupRepository;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


public class LookupServiceImplTest {

    private LookupRepository repository;
    private LookupService service;

    @Before
    public void setUp() {
        repository = mock(LookupRepository.class);
        service = new LookupServiceImpl(repository);
    }

    @Test
    public void create() {
        String code = "002";
        Lookup lookup = lookup(null, code);
        when(repository.save(lookup)).thenReturn(lookup);
        when(repository.existsByCode(code)).thenReturn(false);

        Lookup created = service.create(lookup);
        assertThat(created.getUuid()).isNotEmpty();
        verify(repository).save(lookup);
        verify(repository).existsByCode(code);
    }


    @Test(expected = DuplicateLookupException.class)
    public void createWhenDuplicateCodeShouldRaiseException() {
        String code = "002";
        Lookup lookup = lookup(null, code);
        when(repository.existsByCode(code)).thenReturn(true);

        service.create(lookup);
        verify(repository).existsByCode(code);
    }

    @Test
    public void get() {
        String uuid = "2";
        Lookup lookup = lookup(uuid);
        lookup.setUuid(uuid);
        when(repository.findBy(uuid)).thenReturn(lookup);

        assertThat(service.get(uuid).getUuid()).isEqualTo(uuid);
        verify(repository).findBy(uuid);
    }

    @Test
    public void repair() {
        String uuid = "2";
        String code = "003";
        Lookup onSystem = lookup(uuid, 2L);
        Lookup updatingItem = lookup(uuid, code, "Test Category", "Test desc", "Additional Info");

        when(repository.existsByCodeAndUuidNot(code, uuid)).thenReturn(false);
        when(repository.findBy(uuid)).thenReturn(onSystem);
        when(repository.save(updatingItem)).thenReturn(updatingItem);

        Lookup repaired = service.repair(uuid, updatingItem);
        assertThat(repaired).isEqualTo(updatingItem);
        assertThat(repaired.getId()).isEqualTo(onSystem.getId());
        verify(repository).findBy(uuid);
        verify(repository).existsByCodeAndUuidNot(code, uuid);
    }

    @Test(expected = DuplicateLookupException.class)
    public void repairWhenDuplicateCodeShouldRaiseException() {
        String uuid = "2";
        String code = "003";
        Lookup updatingItem = lookup(uuid, code, "Test Category", "Test desc", "Additional Info");

        when(repository.existsByCodeAndUuidNot(code, uuid)).thenReturn(true);

        service.repair(uuid, updatingItem);
        verify(repository).existsByCodeAndUuidNot(code, uuid);
    }


    private static Lookup lookup(String uuid) {
        Lookup lookup = new Lookup();
        lookup.setUuid(uuid);
        return lookup;
    }

    private static Lookup lookup(String uuid, Long id) {
        Lookup lookup = lookup(uuid);
        lookup.setId(id);
        return lookup;
    }

    private static Lookup lookup(String uuid, String code) {
        Lookup lookup = lookup(uuid);
        lookup.setCode(code);
        return lookup;
    }

    private static Lookup lookup(String uuid, String code, String category, String desc, String additionalInfo) {
        Lookup lookup = lookup(uuid);
        lookup.setCode(code);
        lookup.setCategory(category);
        lookup.setDescription(desc);
        lookup.setAdditionalInfo(additionalInfo);
        return lookup;
    }
}