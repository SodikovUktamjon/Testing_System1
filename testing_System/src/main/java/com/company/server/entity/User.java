package com.company.server.entity;

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
    private List<TestHistory> testHistory=new ArrayList<>();
}
