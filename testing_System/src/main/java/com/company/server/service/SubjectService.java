package com.company.server.service;

import com.company.server.database.Database;
import com.company.server.entity.Subject;
import com.company.server.util.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import java.awt.*;
import java.io.*;
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

    public File watchSubjects(){
        Subject[] subjectsInDatabase = Database.getSubjectsInDatabase();
        ArrayList<Subject> subjects = new ArrayList<>(List.of(subjectsInDatabase));

        File file=new File("src/main/resources/subjectWord.docx");
        try (FileOutputStream outputStream = new FileOutputStream(file);
             XWPFDocument document=new XWPFDocument();
        ) {

            XWPFTable table = document.createTable();
            table.setWidth("100%");
            XWPFTableRow headerRow = table.getRow(0);

            XWPFTableCell cell = headerRow.getCell(0);
            cell.setWidth("50%");
            cell.setText("Subjects");

            XWPFTableCell cell1 = headerRow.createCell();
            cell1.setWidth("50%");
            cell1.setText("Soni");

            for (Subject subject : subjects) {
                XWPFTableRow row = table.createRow();
                row.getCell(0).setText(subject.getName());
                row.getCell(1).setText(String.valueOf(subject.getQuestions().size()));
            }

            document.write(outputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }


}
