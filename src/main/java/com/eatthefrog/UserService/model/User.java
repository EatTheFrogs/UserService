package com.eatthefrog.UserService.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Data
@Builder
@Document(collection = "goals")
public class User implements Serializable {

    @Id
    private String uuid;
    private String email;
    private String name;
    private ZonedDateTime createdDate;
}
