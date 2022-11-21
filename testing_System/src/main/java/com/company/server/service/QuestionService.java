package com.company.server.service;

import com.company.server.database.Database;
import com.company.server.entity.Question;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class QuestionService {

    public static void addQuestiontoDatabase(String text,String subjectName, String correctAnswer, List<String> variations){
        if(text==null || text.isBlank()){
            throw new NullPointerException("Savol bo'sh bo'lishi mumkin emas!");
        }
        if(correctAnswer==null || correctAnswer.isBlank()){
            throw new NullPointerException("To'g'ri javob bolishi shart!");
        }
        if(variations==null || variations.size()==0){
            throw new NullPointerException("Variantlar bolishi shart!");
        }
        File file = new File("src/main/resources/questions.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try( Writer writer = new FileWriter(file)) {

            writer.write(gson.toJson(new Question(UUID.randomUUID(),text,correctAnswer,subjectName,variations)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static File getQuestionListInExcelSheets(){
        Question[] questionsInDatabase = Database.getQuestionsInDatabase();
        File file = new File("src/main/resources/questions.xlsx");
        try (XSSFWorkbook questionsBook = new XSSFWorkbook(); FileOutputStream outputStream = new FileOutputStream(file)) {

            Map<String , List<Question>> questionsMap = new HashMap<>();
            for (Question question : questionsInDatabase) {
                if(questionsMap.containsKey(question.getSubjectName())){
                    questionsMap.get(question.getSubjectName()).add(question);
                }
                else{
                    questionsMap.put(question.getSubjectName(),new ArrayList<>(List.of(question)));
                }
            }

            for (String questionSheet : questionsMap.keySet()) {
                XSSFSheet sheet = questionsBook.createSheet(questionSheet);
                XSSFRow headerRow = sheet.createRow(0);

                XSSFCell cell00 = headerRow.createCell(0);
                cell00.setCellValue("Subject Name");

                XSSFCell cell01 = headerRow.createCell(1);
                cell00.setCellValue("Question text");

                XSSFCell cell02 = headerRow.createCell(2);
                cell00.setCellValue("Variants");

                XSSFCell cell03 = headerRow.createCell(3);
                cell00.setCellValue("To'g'ri javob");

                int indexQuestion = 0;
                for (Question question : questionsMap.get(questionSheet)) {
                    XSSFRow row = sheet.createRow(++indexQuestion);
                    row.createCell(0).setCellValue(question.getSubjectName());
                    row.createCell(1).setCellValue(question.getText());
                    row.createCell(2).setCellValue(question.getVariants().toString());
                    row.createCell(3).setCellValue(question.getCorrectAnswer());
                }

                questionsBook.write(outputStream);


            }


            return file;



        } catch (IOException  e) {
            throw new RuntimeException(e);
        }


    }
}
