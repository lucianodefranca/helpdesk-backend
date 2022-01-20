package com.luciano.helpdesk.config;

import com.luciano.helpdesk.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Autowired
    private DBService dbservice;

    @Bean
    public void instanciaDB() {
        this.dbservice.instanciaDB();
    }
}
