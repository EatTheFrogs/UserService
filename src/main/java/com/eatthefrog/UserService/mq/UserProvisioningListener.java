package com.eatthefrog.UserService.mq;

import com.eatthefrog.UserService.converter.OktaRequestConverter;
import com.eatthefrog.UserService.model.User;
import com.eatthefrog.UserService.model.okta.OktaRequest;
import com.eatthefrog.UserService.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Log
@Component
@RequiredArgsConstructor
public class UserProvisioningListener {

    private final OktaRequestConverter oktaRequestConverter;
    private final UserService userService;

    @RabbitListener(queues = { "${ETF.PROVISIONING.CREATE.QUEUE}" })
    public void receiveCreateMessage(@Payload OktaRequest oktaRequest) {
        log.info("Create user message received:\n"+oktaRequest);
        User user = oktaRequestConverter.getUserFromOktaRequest(oktaRequest);
        log.info("Saving new user:\n"+user);
        userService.saveUser(user);
    }

    @RabbitListener(queues = { "${ETF.PROVISIONING.DELETE.QUEUE}" })
    public void receiveDeleteMessage(@Payload OktaRequest oktaRequest) {
        log.info("Delete user message received:\n"+oktaRequest);
        User user = oktaRequestConverter.getUserFromOktaRequest(oktaRequest);
        log.info("Deleting user:\n"+user);
        userService.deleteUser(user);
    }
}
