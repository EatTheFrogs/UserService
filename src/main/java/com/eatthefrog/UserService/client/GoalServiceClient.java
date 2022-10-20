package com.eatthefrog.UserService.client;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class GoalServiceClient {

    private static final String DELETE_ALL_PATH = "/delete/user/{userUuid}";

    private final WebClient goalServiceWebClient;

    public void deleteAllGoalsForUser(String userUuid) {
        goalServiceWebClient.delete()
                .uri(uriBuilder -> uriBuilder.path(DELETE_ALL_PATH)
                        .build(userUuid))
                .retrieve()
                .bodyToMono(Object.class)
                .block();
    }
}
