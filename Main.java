package com.company;
import java.io.*;
import java.nio.BufferOverflowException;
import java.util.*;

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
                line = buf.readLine();
                if (line == null){
                    break;
                }
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
            Collections.sort(studentList);
            Iterator<Student> iterator = studentList.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }
            // ------------------------------------------------------------
            menu(studentList);
//            for (int i = 0; i < studentList.size(); i++) {
//                if (iterator.hasNext()){
//                    System.out.println(iterator.next());
//                }
//            }
            // вывести коллекцию с помощью итератора и закомитить
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void menu(List<Student> students) {
        boolean flag = true;
        while (flag) {
            System.out.println("1. Отсортировать по фамилии");
            System.out.println("2. Отсортировать по зарплате");
            System.out.println("3. Отсортировать по среднему баллу");
            System.out.println("4. Отсортировать по льготности");
            System.out.println("5. Выход");

            Scanner scanner = new Scanner(System.in);
            int scan = scanner.nextInt();
            switch (scan) {
                case 1:
                    System.out.println("Отсортировать по фамилии");

                    students.sort(new Comparator<Student>() {
                        @Override
                        public int compare(Student o1, Student o2) {
                            return o1.getSurname().compareTo(o2.getSurname());
                        }
                    });

                    break;
                case 2:
                    System.out.println("Отсортировать по зарплате");

                    students.sort(new Comparator<Student>() {
                        @Override
                        public int compare(Student o1, Student o2) {
                            if (o1.getSalary() > (o2.getSalary()))
                                return -1;
                            else if (o1.getSalary() < (o2.getSalary()))
                                return 1;
                            else
                                return 0;
                        }
                    });
                    break;
                case 3:
                    System.out.println("Отсортировать по среднему баллу");

                    students.sort(new Comparator<Student>() {
                        @Override
                        public int compare(Student o1, Student o2) {
                            if (o1.getAvgGrade() > (o2.getAvgGrade()))
                                return -1;
                            else if (o1.getAvgGrade() < (o2.getAvgGrade()))
                                return 1;
                            else
                                return 0;
                        }
                    });
                    break;
                case 4:
                    System.out.println("Отсортировать по льготности");
                    students.sort(new Comparator<Student>() {
                        @Override
                        public int compare(Student o1, Student o2) {
                            if (o1.isAboutFamily())
                                return -1;
                            else if (o2.isAboutFamily())
                                return 1;
                            else
                                return 0;
                        }
                    });
                    break;
                case 5:
                    System.out.println("Программа завершена...");
                    flag = false;
                    break;
                default:
                    System.out.println("Такого пункта меню нет :( Попробуйте снова");
            }
            for (Student student : students) {
                System.out.println(student);
            }
            // закомитить на гитхаб
        }
    }
}
