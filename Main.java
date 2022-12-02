package com.company;
import java.io.*;
import java.nio.BufferOverflowException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // Написать проект для директора общаги чтоб он мог вычислить всех студентов и тд

        try {
            File file = new File("src/com/company/Students");
            FileReader fileReader = new FileReader(file);
            BufferedReader buf = new BufferedReader(fileReader);
            List<Student> studentList = new ArrayList<Student>();
            String line = buf.readLine();
            String[] items;
            Student student;

            String surname;
            int[] marks;
            int salary;
            String group;
            boolean aboutFamily;

            String[] stMarks;
            while (line != null) {
                System.out.println(line);
                line = buf.readLine();
                items = line.split(";");
                stMarks = items[1].split(" ");
                marks = new int[stMarks.length];
                for (int i = 0; i < stMarks.length; i++) {
                    marks[i] = Integer.parseInt(stMarks[i]);
                }
                surname = items[0];
                salary = Integer.parseInt(items[2]);
                group = items[3];
                aboutFamily = Boolean.parseBoolean(items[4]);
                student = new Student(surname, marks, salary, group, aboutFamily);
                studentList.add(student);
            }
            Iterator<Student> iterator = studentList.iterator();
            for (int i = 0; i < studentList.size(); i++) {
                if (iterator.hasNext()){
                    System.out.println();
                }
            }
            // вывести коллекцию с помощью итератора и закомитить
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
