package dev.reddy.boot_master.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegistrationRequest {

    @NotNull(message = "username must not be null")
    @NotBlank(message = "username must not be blank")
    @NotEmpty(message = "username must not be empty")
    private String username;
}
