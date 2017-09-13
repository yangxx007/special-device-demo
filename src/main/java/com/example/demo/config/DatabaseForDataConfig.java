package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        basePackages = "com.example.demo.Dao.apply",
        entityManagerFactoryRef ="productEntityManager",
        transactionManagerRef = "productTransactionManager"

)
public class DatabaseForDataConfig {
    @Autowired
    private org.springframework.core.env.Environment env;

    @Bean

    public LocalContainerEntityManagerFactoryBean productEntityManager() {

        LocalContainerEntityManagerFactoryBean
                em = new

                LocalContainerEntityManagerFactoryBean();

        em.setDataSource(productDataSource());

        em.setPackagesToScan(new

                String[] {"com.example.demo.entity.formModel","com.example.demo.entity.dataModel","com.example.demo" +
                ".entity.deviceModel"

        });



        HibernateJpaVendorAdapter
                vendorAdapter = new

                HibernateJpaVendorAdapter();

        em.setJpaVendorAdapter(vendorAdapter);

        HashMap<String, Object> properties = new HashMap<String, Object>();

        properties.put("hibernate.hbm2ddl.auto",
                env.getProperty("spring.jpa.hibernate.ddl-auto"));

        properties.put("hibernate.dialect",
                env.getProperty("spring.jpa.properties.hibernate.dialect"));

        em.setJpaPropertyMap(properties);



        return

                em;

    }


    @Bean

    public DataSource productDataSource() {

        DriverManagerDataSource
                dataSource = new

                DriverManagerDataSource();

        dataSource.setDriverClassName(env.getProperty("spring.datasource.test2.driver-class-name"));

        dataSource.setUrl(env.getProperty("spring.datasource.test2.url"));

        dataSource.setUsername(env.getProperty("spring.datasource.test2.name"));

        dataSource.setPassword(env.getProperty("spring.datasource.test2.password"));



        return

                dataSource;
    }


    @Bean

    public PlatformTransactionManager productTransactionManager() {

        JpaTransactionManager
                transactionManager = new

                JpaTransactionManager();

        transactionManager.setEntityManagerFactory(productEntityManager().getObject());

        return

                transactionManager;

    }

}




