package com.eatthefrog.UserService.service;

import com.eatthefrog.UserService.client.GoalServiceClient;
import com.eatthefrog.UserService.controller.UserController;
import com.eatthefrog.UserService.model.User;
import com.eatthefrog.UserService.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final GoalServiceClient goalServiceClient;

    public User getUser(String uuid) {
        return userRepo.findFirstByUuid(uuid)
                .orElseThrow(() -> new UserController.ResourceNotFoundException("Could not find user with uuid "+ uuid));
    }

    public void saveUser(User user) {
        userRepo.save(user);
    }

    public void deleteUser(User user) {
        goalServiceClient.deleteAllGoalsForUser(user.getUuid());
        userRepo.deleteById(user.getUuid());
    }
}
