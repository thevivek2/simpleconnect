package com.eaglessoar.simpleconnect.module.seeker.provider;

import com.eaglessoar.simpleconnect.api.ProviderApiDelegate;
import com.eaglessoar.simpleconnect.api.model.PageModel;
import com.eaglessoar.simpleconnect.api.model.ProviderRequest;
import com.eaglessoar.simpleconnect.api.model.ProviderResponse;
import com.eaglessoar.simpleconnect.api.model.ProviderResponsePage;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProviderController implements ProviderApiDelegate {

    private final ProviderService service;
    private final ProviderMapper mapper;
    private final ProviderMongoRepository jpaRepository;

    @Override
    public ResponseEntity<ProviderResponse> providerPost(ProviderRequest providerRequest) {
        Provider provider = mapper.toModel(providerRequest);
        provider.setName("anonymous");
        return ResponseEntity.ok(mapper.toResponse(service.create(provider)));
    }

    @Override
    public ResponseEntity<ProviderResponsePage> providerGet() {
        Page<ProviderDoc> all = jpaRepository.findAll(PageRequest.of(0, 1000, Sort.by(Sort.Order.desc("createdOn"))));
        PageModel pageInfo = new PageModel();
        pageInfo.setPageNumber(all.getNumber());
        pageInfo.setSize(all.getSize());
        pageInfo.setTotalElements(all.getTotalElements());
        pageInfo.setTotalPages(all.getTotalPages());
        ProviderResponsePage content = new ProviderResponsePage().content(mapper.toResponse(all.getContent())).pageInfo(pageInfo);
        return ResponseEntity.ok(content);

    }

    @Override
    public ResponseEntity<ProviderResponse> providerUuidGet(String uuid) {
        return ResponseEntity.ok(mapper.toResponse(service.get(uuid)));
    }

    @Override
    public ResponseEntity<ProviderResponse> providerUuidPut(String uuid, ProviderRequest providerRequest) {
        return null;
    }

    @Override
    public ResponseEntity<ProviderResponsePage> providerSearchGet(String searchStr) {
        return ResponseEntity.ok(new ProviderResponsePage().content(mapper.map(service.search(searchStr))));
    }
}
