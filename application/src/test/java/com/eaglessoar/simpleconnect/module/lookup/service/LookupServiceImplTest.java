package com.eaglessoar.simpleconnect.module.lookup.service;

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
        Lookup lookup = new Lookup();
        when(repository.save(lookup)).thenReturn(lookup);

        Lookup created = service.create(lookup);
        assertThat(created.getUuid()).isNotEmpty();
        verify(repository).save(lookup);
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
        Lookup updatingItem = lookup(uuid, "Summary", "Test desc");

        when(repository.findBy(uuid)).thenReturn(onSystem);
        when(repository.save(updatingItem)).thenReturn(updatingItem);

        Lookup repaired = service.repair(uuid, updatingItem);
        assertThat(repaired).isEqualTo(updatingItem);
        assertThat(repaired.getId()).isEqualTo(onSystem.getId());
        verify(repository).findBy(uuid);
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


    private static Lookup lookup(String uuid, String summary, String desc) {
        Lookup lookup = lookup(uuid);
        lookup.setSummary(summary);
        lookup.setDescription(desc);
        return lookup;
    }
}