package com.eatthefrog.UserService.repository;

import com.eatthefrog.UserService.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, String> {

}
