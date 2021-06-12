package com.github.frostbittenking.pgjdbcBugDemo;

import com.github.frostbittenking.pgjdbcBugDemo.persistence.jpa.entity.EntityBasePackage;
import com.github.frostbittenking.pgjdbcBugDemo.persistence.jpa.repository.DemoJpaModule;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootApplication(scanBasePackageClasses = DemoBasePath.class)
@EntityScan(basePackageClasses = EntityBasePackage.class)
@Configuration
@EnableJpaRepositories(basePackageClasses = DemoJpaModule.class)
public class TestConfiguration {
}
