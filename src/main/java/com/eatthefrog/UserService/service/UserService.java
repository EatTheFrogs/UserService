package com.eatthefrog.UserService.service;

import com.eatthefrog.UserService.model.User;
import com.eatthefrog.UserService.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public void saveUser(User user) {
        userRepo.save(user);
    }

    public void deleteUser(User user) {
        userRepo.deleteById(user.getUuid());
    }
}
