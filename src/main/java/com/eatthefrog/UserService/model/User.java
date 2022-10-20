package com.eatthefrog.UserService.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Data
@Builder
@Document(collection = "user")
public class User implements Serializable {

    @Id
    private String uuid;
    private ZonedDateTime createdDate;
    private String name;
    private String email;
}
