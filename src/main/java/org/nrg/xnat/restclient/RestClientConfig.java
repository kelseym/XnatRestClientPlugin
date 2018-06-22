package org.nrg.xnat.restclient;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import org.nrg.framework.annotations.XnatPlugin;
import org.nrg.xnat.initialization.RootConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
@XnatPlugin(value = "rest_client_plugin",
        name = "XNAT REST Client Plugin",
        description = "Enables users to GET/POST/PUT against local REST endpoints.",
        entityPackages = "org.nrg.xnat.restclient",
        log4jPropertiesFile = "META-INF/resources/log4j.properties",
        version = ""
)
@ComponentScan(value = "org.nrg.xnat.restclient", excludeFilters = @Filter(type = FilterType.REGEX, pattern = ".*TestConfig.*", value = {}))
@Import({RootConfig.class})
public class RestClientConfig {

    @Bean
    public Module guavaModule() {
        return new GuavaModule();
    }

    @Bean
    public ObjectMapper objectMapper(final Jackson2ObjectMapperBuilder objectMapperBuilder) {
        return objectMapperBuilder.build();
    }
}