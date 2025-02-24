package dev.reddy.boot_master.events;

import lombok.Data;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;


public class UserRegistrationEvent extends ApplicationEvent {
    @Getter
    private String username;
    public UserRegistrationEvent(Object source, String username) {
        super(source);
        this.username = username;
    }
}
