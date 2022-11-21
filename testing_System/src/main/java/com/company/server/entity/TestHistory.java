package com.company.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TestHistory {
    private UUID id;
    private Integer questionNumber;
    private Integer correctQuestions;
    private String subjectName;
    private final LocalDateTime localDateTime=LocalDateTime.now();
}
