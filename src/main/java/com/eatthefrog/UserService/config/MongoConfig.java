package com.eatthefrog.UserService.config;

import com.eatthefrog.UserService.converter.DateReadingConverter;
import com.eatthefrog.UserService.converter.DateWritingConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
public class MongoConfig {

    private final DateWritingConverter dateWritingConverter;
    private final DateReadingConverter dateReadingConverter;

    @Bean
    public MongoCustomConversions mongoCustomConversions() {
        return new MongoCustomConversions(
            Arrays.asList(
                dateWritingConverter,
                dateReadingConverter));
    }
}
