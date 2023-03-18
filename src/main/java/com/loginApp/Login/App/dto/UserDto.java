package com.loginApp.Login.App.dto;

import com.loginApp.Login.App.model.Role;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private Long id;
    @NotEmpty(message = "Enter valid name")
    private String name;
    @NotEmpty(message = "Enter valid email")
    private String email;
    @NotEmpty(message = "Enter valid password")
    private String password;
    private Role role;
}
