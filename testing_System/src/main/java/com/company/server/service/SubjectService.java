package com.company.server.service;

import com.company.server.database.Database;
import com.company.server.entity.Subject;
import com.company.server.util.Result;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SubjectService {

    public Result addSubject(String name){
        Subject[] subjects= Database.getSubjectsInDatabase();
        ArrayList<Subject> subjects1 = new ArrayList<>(List.of(subjects));

        Subject subject=new Subject(UUID.randomUUID(), name, new ArrayList<>());
        subjects1.add(subject);

        ObjectMapper mapper=new ObjectMapper();
        try(FileWriter writer=new FileWriter("src/main/resources/subjects.json")) {
            mapper.writeValue(writer, subjects1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Result("Success", true);
    }
}
