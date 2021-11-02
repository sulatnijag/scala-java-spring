package com.explore.scalajavaspring;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.explore.scalajavaspring.repository")
@EnableTransactionManagement
public class JpaConfiugration {
}
