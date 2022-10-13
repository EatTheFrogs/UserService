package com.eatthefrog.UserService.converter;

import com.eatthefrog.UserService.model.okta.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Component
public class OktaRequestConverter {

    public OktaUser getOktaUserFromOktaRequest(OktaRequest request) {
        OktaRequestEventTarget target = Optional.ofNullable(request.getData())
                .map(OktaRequestData::getEvents)
                .map(List::stream)
                .orElseGet(Stream::empty)
                .findFirst()
                .map(OktaRequestEvent::getTarget)
                .map(List::stream)
                .orElseGet(Stream::empty)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Failed to parse user in Okta create hook:\n"+request.toString()));

        return OktaUser.builder()
                .oktaUUID(Optional.ofNullable(target.getId()).get())
                .email(Optional.ofNullable(target.getAlternateId()).get())
                .name(Optional.ofNullable(target.getDisplayName()).get())
                .build();
    }
}
