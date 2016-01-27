package me.wilk.robert.asme.config;

import me.wilk.robert.asme.service.SomethingService;
import org.hibernate.jpa.internal.EntityManagerFactoryImpl;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

/**
 * @author Robert Wilk
 *         Created on 1/20/2016.
 */
@Configuration
@EnableJpaRepositories("me.wilk.robert.asme.repository")
@EnableTransactionManagement
@EntityScan("me.wilk.robert.asme.entity")
public class AppConfig {

    @Bean
    public HibernateJpaSessionFactoryBean sessionFactoryBean(final EntityManagerFactory emf) {
        HibernateJpaSessionFactoryBean factoryBean = new HibernateJpaSessionFactoryBean();
        factoryBean.setEntityManagerFactory(emf);
        return factoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(emf);
        return jpaTransactionManager;
    }

    @Bean
    public SomethingService somethingService() {
        return new SomethingService();
    }
}
