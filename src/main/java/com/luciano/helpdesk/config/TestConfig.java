package com.luciano.helpdesk.config;

import com.luciano.helpdesk.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(value = "test")
public class TestConfig {

    @Autowired
    private DBService dbservice;

    public void instanciaDB() {
        this.dbservice.instanciaDB();
    }
}
