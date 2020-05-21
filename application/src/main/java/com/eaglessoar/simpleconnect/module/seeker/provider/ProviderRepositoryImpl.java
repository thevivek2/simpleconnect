package com.eaglessoar.simpleconnect.module.seeker.provider;

import com.eaglessoar.simpleconnect.exception.ProviderNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ProviderRepositoryImpl implements ProviderRepository {

    private final ProviderMongoRepository mongoRepository;
    private final ProviderMapper mapper;
    private final MongoTemplate template;

    @Override
    public Provider findBy(String id) {
        return mapper.toModel(mongoRepository.findById(id).orElseThrow(ProviderNotFoundException.uuid(id)));
    }

    @Override
    public Provider save(Provider provider) {
        return mapper.toModel(mongoRepository.save(mapper.toDoc(provider)));
    }

    @Override
    public List<Provider> search(String searchKey) {
        TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny(searchKey.split("\\s+"));
        Query query = TextQuery.queryText(criteria).sortByScore();
        return mapper.toModel(template.find(query, ProviderDoc.class));
    }

}
