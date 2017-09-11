package com.example.demo.config;

/**
 * Created by yang on 2017/7/26.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * Created by yang on 2017/7/20.
 */
@Configuration

@PropertySource({"classpath:application.properties"})
@EnableJpaRepositories(
        basePackages = "com.example.demo.Dao.user",
        entityManagerFactoryRef ="userEntityManager",
        transactionManagerRef = "userTransactionManager"

)
public class DatabaseForUserConfig {
    @Autowired
    private org.springframework.core.env.Environment env;

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean userEntityManager() {

        LocalContainerEntityManagerFactoryBean
                em = new

                LocalContainerEntityManagerFactoryBean();

        em.setDataSource(userDataSource());

        em.setPackagesToScan(new

                String[] { "com.example.demo.entity.userModel"

        });



        HibernateJpaVendorAdapter
                vendorAdapter = new

                HibernateJpaVendorAdapter();

        em.setJpaVendorAdapter(vendorAdapter);

        HashMap<String, Object> properties = new HashMap<String, Object>();

        properties.put("hibernate.hbm2ddl.auto",
                env.getProperty("spring.jpa.hibernate.ddl-auto"));

        properties.put("hibernate.hbm2ddl.import_files",
               "database/import.sql");

        properties.put("hibernate.dialect",
                env.getProperty("spring.jpa.properties.hibernate.dialect"));


        em.setJpaPropertyMap(properties);



        return

                em;

    }

    @Primary

    @Bean

    public DataSource userDataSource() {

        DriverManagerDataSource
                dataSource = new

                DriverManagerDataSource();

        dataSource.setDriverClassName(env.getProperty("spring.datasource.test.driver-class-name"));

        dataSource.setUrl(env.getProperty("spring.datasource.test.url"));


        dataSource.setUsername(env.getProperty("spring.datasource.test.name"));

        dataSource.setPassword(env.getProperty("spring.datasource.test.password"));



        return

                dataSource;
    }
    @Primary

    @Bean

    public PlatformTransactionManager userTransactionManager() {

        JpaTransactionManager
                transactionManager = new

                JpaTransactionManager();

        transactionManager.setEntityManagerFactory(userEntityManager().getObject());

        return

                transactionManager;

    }

}