package org.nrg.xnat.restclient.services;

import org.nrg.framework.exceptions.NotFoundException;
import org.nrg.framework.orm.hibernate.BaseHibernateService;
import org.nrg.xnat.restclient.entities.RestClientEndpointEntity;
import org.nrg.xnat.restclient.model.RestClientEndpoint;

import javax.annotation.Nonnull;
import java.util.List;

public interface RestClientEndpointEntityService extends BaseHibernateService<RestClientEndpointEntity> {


    public RestClientEndpoint save(@Nonnull RestClientEndpoint endpoint);
    public void delete(@Nonnull Long endpointId) throws NotFoundException;
    public void delete(@Nonnull RestClientEndpoint endpoint) throws NotFoundException;
    public List<RestClientEndpoint> get();
    public RestClientEndpoint get(Long id) throws NotFoundException;

}
