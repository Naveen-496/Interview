package dev.reddy.boot_master.routes;

import dev.reddy.boot_master.dto.UserRegistrationRequest;
import dev.reddy.boot_master.events.UserRegistrationEvent;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserRoutes {

    private final ApplicationEventPublisher eventPublisher;

    public UserRoutes(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @PostMapping("/")
    public String registerUser(@RequestBody @Valid UserRegistrationRequest body) {
        log.info("Request Body: {}", body);
        eventPublisher.publishEvent(new UserRegistrationEvent(this, body.getUsername()));
        return body.getUsername() + " registered successfully!";
    }
}
