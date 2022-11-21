package com.company.server.entity;

import com.company.server.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private UUID id;
    private String fullName;
    private String login;
    private String password;
    private UserType userType=UserType.USER;
    private List<TestHistory> testHistory=new ArrayList<>();
}
