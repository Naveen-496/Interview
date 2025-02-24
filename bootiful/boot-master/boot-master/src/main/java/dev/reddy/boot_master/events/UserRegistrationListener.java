package dev.reddy.boot_master.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserRegistrationListener {

    @EventListener
    public void printUserRegistration(UserRegistrationEvent event) {
        log.info("Registration Event for User: {}", event.getUsername());
    }
}
