package org.nrg.xnat.restclient.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({HibernateConfig.class, ObjectMapperConfig.class})
public class RestClientTestConfig {
}
