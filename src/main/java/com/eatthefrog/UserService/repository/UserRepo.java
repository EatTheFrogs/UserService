package com.eatthefrog.UserService.repository;

import com.eatthefrog.UserService.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepo extends MongoRepository<User, String> {

    public Optional<User> findFirstByUuid(String uuid);
}
