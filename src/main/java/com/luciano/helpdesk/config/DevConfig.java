package com.luciano.helpdesk.config;

import com.luciano.helpdesk.services.DBService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(value = "dev")
public class DevConfig {

    private DBService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddl;

    public boolean instanciaDB() {

        if (ddl.equals("update")) {
            this.dbService.instanciaDB();
        }
        return false;
    }
}
