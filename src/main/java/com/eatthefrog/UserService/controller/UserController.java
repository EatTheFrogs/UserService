package com.eatthefrog.UserService.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.security.Principal;

@Log
@RestController
@RequiredArgsConstructor
public class UserController {

    @PreAuthorize("#uuid == authentication.token.claims['uid']")
    @GetMapping("/verify/{uuid}")
    public ResponseEntity verifyUser(@PathVariable String uuid) {
        return ResponseEntity.ok().build();
    }
}
