package org.nrg.xnat.restclient.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import org.springframework.http.HttpHeaders;

import javax.annotation.Nullable;
import java.util.Map;

@AutoValue
@JsonInclude(JsonInclude.Include.ALWAYS)
public abstract class RestClientEndpoint {

    @Nullable @JsonProperty("id")           public abstract Long id();
    @JsonProperty("name")                   public abstract String name();
    @Nullable @JsonProperty("project-id")   public abstract String projectId();
    @Nullable @JsonProperty("active")       public abstract Boolean active();
    @JsonProperty("method")                 public abstract Method method();
    @JsonProperty("url")                    public abstract String url();
    @Nullable @JsonProperty("headers")      public abstract HttpHeaders httpHeaders();
    @Nullable @JsonProperty("request-body") public abstract String requestBody();
    @Nullable @JsonProperty("parameters")   public abstract Map<String, String> parameters();
    @Nullable @JsonProperty("is-valid")     public abstract Boolean isValid();

    @JsonCreator
    public static RestClientEndpoint create(@Nullable @JsonProperty("id")           Long id,
                                            @JsonProperty("name")                   String name,
                                            @Nullable @JsonProperty("project-id")   String projectId,
                                            @Nullable @JsonProperty("active")       Boolean active,
                                            @JsonProperty("method")                 Method method,
                                            @JsonProperty("url")                    String url,
                                            @Nullable @JsonProperty("headers")      HttpHeaders httpHeaders,
                                            @Nullable @JsonProperty("request-body") String requestBody,
                                            @Nullable @JsonProperty("parameteres")  Map<String, String> parameters) {
        return builder()
                .id(id)
                .name(name)
                .projectId(projectId)
                .active(active)
                .method(method)
                .url(url)
                .httpHeaders(httpHeaders)
                .requestBody(requestBody)
                .parameters(parameters)
                .build();
    }

    public static RestClientEndpoint.Builder builder() { return new AutoValue_RestClientEndpoint.Builder(); }


    public enum Method {GET, POST, PUT, DELETE}


    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder id(Long id);

        public abstract Builder name(String name);

        public abstract Builder projectId(String projectId);

        public abstract Builder active(Boolean active);

        public abstract Builder method(Method method);

        public abstract Builder url(String url);

        public abstract Builder httpHeaders(HttpHeaders httpHeaders);

        public abstract Builder requestBody(String requestBody);

        public abstract Builder parameters(Map<String,String> parameters);

        public abstract Builder isValid(Boolean isValid);

        public abstract RestClientEndpoint build();
    }
}
