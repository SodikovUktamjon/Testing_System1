package com.company.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    private UUID id;
    private String text;
    private String correctAnswer;
    private String subjectName;
    private List<String> variants=new ArrayList<>();

}
