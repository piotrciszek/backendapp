package com.backendapp.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
 
@Configuration
public class DataInitializer {
 
    @Autowired JdbcTemplate jdbcTemplate;
     
    @Bean
    CommandLineRunner loadDatabase() {
        return new CommandLineRunner() {
             
            @Override
            public void run(String... args) throws Exception {
                jdbcTemplate.execute("insert into \"AIRPORT\" (icao, name) "
                        + "values ('EPOK', 'Kosakowo')");
                 
                jdbcTemplate.execute("insert into \"AIRPORT\" (icao, name) "
                        + "values ('EPGD', 'Gdansk')"); 
            }
        };
    }
}
