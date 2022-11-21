package com.company.server.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String fullName;
    private String login;
    private String password;
    private String confirmPassword;
}
