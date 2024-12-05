package com.epam.aicode.springpr.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EntityScan("com.epam.aicode.springpr.domain")
@EnableJpaRepositories("com.epam.aicode.springpr.repository")
@EnableTransactionManagement
public class DomainConfig {
}
