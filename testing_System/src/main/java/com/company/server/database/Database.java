
package com.company.server.database;

import com.company.server.entity.Question;
import com.company.server.entity.Subject;
import com.company.server.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public interface Database {
    static Question[] getQuestionsInDatabase() {

        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/main/resources/questions.json");
        try {
            return objectMapper.readValue(file, Question[].class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    static Subject[] getSubjectsInDatabase() {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/main/resources/subjects.json");
        try {
            return objectMapper.readValue(file, Subject[].class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    static User[] getUsersInDatabase() {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/main/resources/users.json");
        try {
            return objectMapper.readValue(file, User[].class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    
}
