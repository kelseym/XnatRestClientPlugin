package org.nrg.xnat.restclient.entities;

import com.google.common.base.Objects;
import org.nrg.framework.orm.hibernate.AbstractHibernateEntity;
import org.nrg.xnat.restclient.model.RestClientEndpoint;
import org.springframework.http.HttpHeaders;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Map;

@Entity
public class RestClientEndpointEntity extends AbstractHibernateEntity {
    public RestClientEndpointEntity() { }

    private long id;
    private String name;
    private String projectId;
    private Boolean active;
    private RestClientEndpoint.Method method;
    private String url;
    private HttpHeaders httpHeaders;
    private String requestBody;
    private Map<String,String> parameters;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "project-id")
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public RestClientEndpoint.Method getMethod() {
        return method;
    }

    public void setMethod(RestClientEndpoint.Method method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @ElementCollection(fetch = FetchType.EAGER)
    public HttpHeaders getHttpHeaders() {
        return httpHeaders;
    }

    public void setHttpHeaders(HttpHeaders httpHeaders) {
        this.httpHeaders = httpHeaders;
    }

    @Column(name = "request-body")
    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    @ElementCollection(fetch = FetchType.EAGER)
    public Map getParameters() {
        return parameters;
    }

    public void setParameters(Map parameters) {
        this.parameters = parameters;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RestClientEndpointEntity)) return false;
        if (!super.equals(o)) return false;
        RestClientEndpointEntity that = (RestClientEndpointEntity) o;
        return id == that.id &&
                Objects.equal(name, that.name) &&
                Objects.equal(projectId, that.projectId) &&
                Objects.equal(active, that.active) &&
                method == that.method &&
                Objects.equal(url, that.url) &&
                Objects.equal(httpHeaders, that.httpHeaders) &&
                Objects.equal(requestBody, that.requestBody) &&
                Objects.equal(parameters, that.parameters);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), id, name, projectId, active, method, url, httpHeaders, requestBody, parameters);
    }

    @Override
    public String toString() {
        return "RestClientEndpointEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", projectId='" + projectId + '\'' +
                ", active=" + active +
                ", method=" + method +
                ", url='" + url + '\'' +
                ", httpHeaders=" + httpHeaders +
                ", requestBody='" + requestBody + '\'' +
                ", parameters='" + parameters + '\'' +
                '}';
    }

    @Transient
    public RestClientEndpoint toPoJo(){
        return RestClientEndpoint.builder()
                .id(this.getId())
                .name(this.getName())
                .projectId(this.getProjectId())
                .active(this.getActive())
                .method(this.getMethod())
                .url(this.getUrl())
                .httpHeaders(this.getHttpHeaders())
                .requestBody(this.getRequestBody())
                .parameters(this.getParameters())
                .build();
    }

    public static RestClientEndpointEntity fromPoJo(final RestClientEndpoint endpoint){
        return fromPojoWithTemplate(endpoint, new RestClientEndpointEntity());
    }

    public static RestClientEndpointEntity fromPojoWithTemplate(final RestClientEndpoint endpoint, final RestClientEndpointEntity templateEndpointEntity){
        if(templateEndpointEntity==null){
            return fromPoJo(endpoint);
        }
        if(endpoint==null){
            return null;
        }
        templateEndpointEntity.name        = endpoint.name()        != null ? endpoint.name()        : templateEndpointEntity.name       ;
        templateEndpointEntity.projectId   = endpoint.projectId()   != null ? endpoint.projectId()   : templateEndpointEntity.projectId  ;
        templateEndpointEntity.active      = endpoint.active()      != null ? endpoint.active()      : templateEndpointEntity.active     ;
        templateEndpointEntity.method      = endpoint.method()      != null ? endpoint.method()      : templateEndpointEntity.method     ;
        templateEndpointEntity.url         = endpoint.url()         != null ? endpoint.url()         : templateEndpointEntity.url        ;
        templateEndpointEntity.httpHeaders = endpoint.httpHeaders() != null ? endpoint.httpHeaders() : templateEndpointEntity.httpHeaders;
        templateEndpointEntity.requestBody = endpoint.requestBody() != null ? endpoint.requestBody() : templateEndpointEntity.requestBody;
        templateEndpointEntity.parameters  = endpoint.parameters()  != null ? endpoint.parameters()  : templateEndpointEntity.parameters ;

        return templateEndpointEntity;
    }

}
