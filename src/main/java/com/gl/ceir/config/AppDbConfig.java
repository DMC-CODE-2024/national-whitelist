package com.gl.ceir.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {"com.gl.ceir.repository.app"},
        entityManagerFactoryRef = "appEntityManagerFactory",
        transactionManagerRef = "appTransactionManager")
@EntityScan("com.gl.ceir.model.app")
public class AppDbConfig {
    @Autowired
    private Environment env;
    @Bean
    public CommandLineRunner appDbConnectionCheck(DbConnectionChecker dbConnectionChecker) {
        return args -> dbConnectionChecker.checkAppDbConnection(appDataSource());
    }

    @Primary
    @Bean(name = "appEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean appEntityManagerFactory(
            @Qualifier("appDataSource") DataSource dataSource,
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSource)
                .packages("com.gl.ceir.model.app")
                .persistenceUnit("app") // CHANGE TO CEIR
                .properties(jpaProperties())
                .build();

    }

    @Primary
    @Bean(name = "appTransactionManager")
    public PlatformTransactionManager appTransactionManager(
            @Qualifier("appEntityManagerFactory") LocalContainerEntityManagerFactoryBean appEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(appEntityManagerFactory.getObject()));
    }

    // DataSource Configs
    @Primary
    @Bean(name = "appDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource appDataSource() {
        if ("oracle".equals(env.getProperty("spring.profiles.active"))) {
            return DataSourceBuilder.create()
                    .url(env.getProperty("spring.input.datasource.oracle.url"))
                    .username(env.getProperty("spring.input.datasource.oracle.username"))
                    .password(env.getProperty("spring.input.datasource.oracle.password"))
                    .driverClassName(env.getProperty("spring.input.datasource.oracle.driver-class-name"))
                    .build();
        } else if ("mysql".equals(env.getProperty("spring.profiles.active"))) {
            if ("app".equals(env.getProperty("nwl.input.schema"))) {
                return DataSourceBuilder.create()
                        .url(env.getProperty("app.datasource.url"))
                        .username(env.getProperty("app.datasource.username"))
                        .password(env.getProperty("app.datasource.password"))
                        .driverClassName(env.getProperty("app.datasource.driver-class-name"))
                        .build();
            } else if ("app_edr".equals(env.getProperty("nwl.input.schema"))) {
                return DataSourceBuilder.create()
                        .url(env.getProperty("app_edr.datasource.url"))
                        .username(env.getProperty("app_edr.datasource.username"))
                        .password(env.getProperty("app_edr.datasource.password"))
                        .driverClassName(env.getProperty("app_edr.datasource.driver-class-name"))
                        .build();
            } else {
                return null;
            }
        } else {
            return null;
        }
    }


    protected Map<String, Object> jpaProperties() {
        Map<String, Object> props = new HashMap<>();
        props.put("hibernate.physical_naming_strategy", "org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy");
        props.put("hibernate.implicit_naming_strategy", SpringImplicitNamingStrategy.class.getName());

        String activeProfile = env.getProperty("spring.profiles.active");

        if ("oracle".equals(activeProfile)) {
            props.put("hibernate.dialect", "org.hibernate.dialect.Oracle12cDialect");
        } else {
            props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        }
        return props;
    }

}
