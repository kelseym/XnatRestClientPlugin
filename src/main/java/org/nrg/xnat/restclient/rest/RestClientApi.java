package org.nrg.xnat.restclient.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.nrg.framework.annotations.XapiRestController;
import org.nrg.framework.exceptions.NotFoundException;
import org.nrg.framework.exceptions.NrgServiceRuntimeException;
import org.nrg.xapi.rest.AbstractXapiRestController;
import org.nrg.xapi.rest.XapiRequestMapping;
import org.nrg.xdat.security.services.RoleHolder;
import org.nrg.xdat.security.services.UserManagementServiceI;
import org.nrg.xnat.restclient.model.RestClientEndpoint;
import org.nrg.xnat.restclient.services.RestClientEndpointEntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.nrg.xdat.security.helpers.AccessLevel.Admin;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Api(description = "API for the XNAT REST Client")
@XapiRestController
public class RestClientApi extends AbstractXapiRestController {
    private static final Logger log = LoggerFactory.getLogger(RestClientApi.class);
    private static final String JSON = MediaType.APPLICATION_JSON_UTF8_VALUE;
    private static final String TEXT = MediaType.TEXT_PLAIN_VALUE;

    private RestClientEndpointEntityService restClientEndpointEntityService;

    @Autowired
    public RestClientApi(final RestClientEndpointEntityService restClientEndpointEntityService,
                         final UserManagementServiceI userManagementService,
                         final RoleHolder roleHolder) {
        super(userManagementService, roleHolder);
        this.restClientEndpointEntityService = restClientEndpointEntityService;
    }

    @XapiRequestMapping(restrictTo = Admin, value = "/restclient/configuration", method = POST)
    @ApiOperation(value = "Create a configured endpoint", code = 201)
    public ResponseEntity<String> createConfiguration(final @RequestBody RestClientEndpoint endpoint)
            throws NrgServiceRuntimeException, JsonProcessingException {

        restClientEndpointEntityService.save(endpoint);
        return new ResponseEntity<>(endpoint.name() + ":" + Long.toString(endpoint.id()), HttpStatus.CREATED);
    }

    @XapiRequestMapping(restrictTo = Admin, value = "/restclient/configurations", method = GET, produces = JSON)
    @ResponseBody
    public List<RestClientEndpoint> getAll()
            throws NrgServiceRuntimeException {
        return restClientEndpointEntityService.get();
    }

    @XapiRequestMapping(restrictTo = Admin, value = {"/restclient/configuration/{id}"}, method = GET, produces = JSON)
    @ApiOperation(value = "Get a configured endpoint by ID")
    @ResponseBody
    public RestClientEndpoint get(final @PathVariable Long id) throws NotFoundException {
        return restClientEndpointEntityService.get(id);
    }

    @XapiRequestMapping(restrictTo = Admin, value = "/restclient/configuration/{id}", method = DELETE)
    @ApiOperation(value="Delete a configured endpoint by ID", code = 204)
    public ResponseEntity<Void> delete(final @PathVariable Long id) throws Exception {
        restClientEndpointEntityService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
