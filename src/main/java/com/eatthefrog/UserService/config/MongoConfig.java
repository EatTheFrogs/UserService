package com.eatthefrog.UserService.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class MongoConfig {

    @Value("${MONGO.USERNAME}")
    private String username;

    @Value("${MONGO.PASSWORD}")
    private String password;

    @Value("${MONGO.DBNAME}")
    private String dbName;

    @Bean
    @Primary
    public MongoProperties mongoProperties() {
        MongoProperties mongoProperties = new MongoProperties();

        String mongoUrl = this.buildMongoUrl();

        mongoProperties.setUri(mongoUrl);
        mongoProperties.setDatabase(dbName);
        mongoProperties.setUsername(username);
        mongoProperties.setPassword(password.toCharArray());

        return mongoProperties;
    }

    private String buildMongoUrl() {
        return null;
    }
}
