package com.eatthefrog.UserService.mq;

import com.eatthefrog.UserService.converter.OktaRequestConverter;
import com.eatthefrog.UserService.model.okta.OktaRequest;
import com.eatthefrog.UserService.model.okta.OktaUser;
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

    @RabbitListener(queues = { "${ETF.PROVISIONING.CREATE.QUEUE}" })
    public void receiveCreateMessage(@Payload OktaRequest oktaRequest) {
        log.info("Create user message received:\n"+oktaRequest);
        OktaUser oktaUser = oktaRequestConverter.getOktaUserFromOktaRequest(oktaRequest);
        log.info("Saving new user:\n"+oktaUser);
    }

    @RabbitListener(queues = { "${ETF.PROVISIONING.DELETE.QUEUE}" })
    public void receiveDeleteMessage(@Payload OktaRequest oktaRequest) {
        log.info("Delete user message received:\n"+oktaRequest);
        OktaUser oktaUser = oktaRequestConverter.getOktaUserFromOktaRequest(oktaRequest);
        log.info("Deleting user:\n"+oktaUser);
    }
}
