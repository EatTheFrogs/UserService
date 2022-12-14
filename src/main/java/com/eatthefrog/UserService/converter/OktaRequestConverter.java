package com.eatthefrog.UserService.converter;

import com.eatthefrog.UserService.model.User;
import com.eatthefrog.UserService.model.okta.*;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Component
public class OktaRequestConverter {

    private static final String OKTA_USER_TYPE = "User";

    public User getUserFromOktaRequest(OktaRequest request) {
        OktaRequestEventTarget eventTarget = Optional.ofNullable(request.getData())
                .map(OktaRequestData::getEvents)
                .map(List::stream)
                .orElseGet(Stream::empty)
                .findFirst()
                .map(OktaRequestEvent::getTarget)
                .map(List::stream)
                .orElseGet(Stream::empty)
                .filter(target -> OKTA_USER_TYPE.equalsIgnoreCase(target.getType()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Failed to parse user in Okta create hook:\n"+request.toString()));

        return User.builder()
                .uuid(Optional.ofNullable(eventTarget.getId()).orElseThrow(() -> new RuntimeException("No uuid found in Okta request.")))
                .email(Optional.ofNullable(eventTarget.getAlternateId()).orElseGet(() -> null))
                .name(Optional.ofNullable(eventTarget.getDisplayName()).orElseGet(() -> null))
                .createdDate(Optional.ofNullable(ZonedDateTime.parse(request.getEventTime())).orElseGet(() -> null))
                .build();
    }
}
