
package org.nrg.xnat.restclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import org.springframework.http.HttpHeaders;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_InternalRestEndpoint extends InternalRestEndpoint {

  private final Long id;
  private final String name;
  private final String projectId;
  private final Boolean active;
  private final InternalRestEndpoint.Method method;
  private final String url;
  private final HttpHeaders httpHeaders;

  private AutoValue_InternalRestEndpoint(
      @Nullable Long id,
      String name,
      @Nullable String projectId,
      @Nullable Boolean active,
      InternalRestEndpoint.Method method,
      String url,
      @Nullable HttpHeaders httpHeaders) {
    this.id = id;
    this.name = name;
    this.projectId = projectId;
    this.active = active;
    this.method = method;
    this.url = url;
    this.httpHeaders = httpHeaders;
  }

  @Nullable
  @JsonProperty(value = "id")
  @Override
  public Long id() {
    return id;
  }

  @JsonProperty(value = "name")
  @Override
  public String name() {
    return name;
  }

  @Nullable
  @JsonProperty(value = "project-id")
  @Override
  public String projectId() {
    return projectId;
  }

  @Nullable
  @JsonProperty(value = "active")
  @Override
  public Boolean active() {
    return active;
  }

  @JsonProperty(value = "method")
  @Override
  public InternalRestEndpoint.Method method() {
    return method;
  }

  @JsonProperty(value = "url")
  @Override
  public String url() {
    return url;
  }

  @Nullable
  @JsonProperty(value = "headers")
  @Override
  public HttpHeaders httpHeaders() {
    return httpHeaders;
  }

  @Override
  public String toString() {
    return "InternalRestEndpoint{"
        + "id=" + id + ", "
        + "name=" + name + ", "
        + "projectId=" + projectId + ", "
        + "active=" + active + ", "
        + "method=" + method + ", "
        + "url=" + url + ", "
        + "httpHeaders=" + httpHeaders
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InternalRestEndpoint) {
      InternalRestEndpoint that = (InternalRestEndpoint) o;
      return ((this.id == null) ? (that.id() == null) : this.id.equals(that.id()))
           && (this.name.equals(that.name()))
           && ((this.projectId == null) ? (that.projectId() == null) : this.projectId.equals(that.projectId()))
           && ((this.active == null) ? (that.active() == null) : this.active.equals(that.active()))
           && (this.method.equals(that.method()))
           && (this.url.equals(that.url()))
           && ((this.httpHeaders == null) ? (that.httpHeaders() == null) : this.httpHeaders.equals(that.httpHeaders()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (id == null) ? 0 : this.id.hashCode();
    h *= 1000003;
    h ^= this.name.hashCode();
    h *= 1000003;
    h ^= (projectId == null) ? 0 : this.projectId.hashCode();
    h *= 1000003;
    h ^= (active == null) ? 0 : this.active.hashCode();
    h *= 1000003;
    h ^= this.method.hashCode();
    h *= 1000003;
    h ^= this.url.hashCode();
    h *= 1000003;
    h ^= (httpHeaders == null) ? 0 : this.httpHeaders.hashCode();
    return h;
  }

  static final class Builder extends InternalRestEndpoint.Builder {
    private Long id;
    private String name;
    private String projectId;
    private Boolean active;
    private InternalRestEndpoint.Method method;
    private String url;
    private HttpHeaders httpHeaders;
    Builder() {
    }
    @Override
    public InternalRestEndpoint.Builder id(@Nullable Long id) {
      this.id = id;
      return this;
    }
    @Override
    public InternalRestEndpoint.Builder name(String name) {
      if (name == null) {
        throw new NullPointerException("Null name");
      }
      this.name = name;
      return this;
    }
    @Override
    public InternalRestEndpoint.Builder projectId(@Nullable String projectId) {
      this.projectId = projectId;
      return this;
    }
    @Override
    public InternalRestEndpoint.Builder active(@Nullable Boolean active) {
      this.active = active;
      return this;
    }
    @Override
    public InternalRestEndpoint.Builder method(InternalRestEndpoint.Method method) {
      if (method == null) {
        throw new NullPointerException("Null method");
      }
      this.method = method;
      return this;
    }
    @Override
    public InternalRestEndpoint.Builder url(String url) {
      if (url == null) {
        throw new NullPointerException("Null url");
      }
      this.url = url;
      return this;
    }
    @Override
    public InternalRestEndpoint.Builder httpHeaders(@Nullable HttpHeaders httpHeaders) {
      this.httpHeaders = httpHeaders;
      return this;
    }
    @Override
    public InternalRestEndpoint build() {
      String missing = "";
      if (this.name == null) {
        missing += " name";
      }
      if (this.method == null) {
        missing += " method";
      }
      if (this.url == null) {
        missing += " url";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_InternalRestEndpoint(
          this.id,
          this.name,
          this.projectId,
          this.active,
          this.method,
          this.url,
          this.httpHeaders);
    }
  }

}
