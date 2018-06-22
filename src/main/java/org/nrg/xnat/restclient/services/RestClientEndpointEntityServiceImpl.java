package org.nrg.xnat.restclient.services;

import org.nrg.framework.exceptions.NotFoundException;
import org.nrg.framework.orm.hibernate.AbstractHibernateEntityService;
import org.nrg.xnat.restclient.daos.RestClientEndpointEntityDao;
import org.nrg.xnat.restclient.entities.RestClientEndpointEntity;
import org.nrg.xnat.restclient.model.RestClientEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class RestClientEndpointEntityServiceImpl
        extends AbstractHibernateEntityService<RestClientEndpointEntity, RestClientEndpointEntityDao>
        implements RestClientEndpointEntityService {

    private static final Logger log = LoggerFactory.getLogger(RestClientEndpointEntityService.class);


    @Override
    public RestClientEndpoint save(@Nonnull RestClientEndpoint endpoint){
        return create(RestClientEndpointEntity.fromPoJo(endpoint)).toPoJo();
    }

    @Override
    public void delete(@Nonnull Long endpointId) throws NotFoundException {
        delete(get(endpointId));
    }

    @Override
    public void delete(@Nonnull RestClientEndpoint endpoint) throws NotFoundException {
        delete(endpoint.id());
    }

    @Override
    public List<RestClientEndpoint> get() {
        List<RestClientEndpointEntity> all = getAll();
        List<RestClientEndpoint> endpoints = new ArrayList<>();
        all.stream().forEach(ep -> endpoints.add(ep.toPoJo()));
        return endpoints;
    }

    @Override
    public RestClientEndpoint get(Long id) throws NotFoundException {
        return super.get(id.longValue()).toPoJo();
    }
}
