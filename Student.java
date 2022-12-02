package com.company;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class Student {

    private String surname;
    private int[] marks;
    private int salary;
    private String group;
    private double avgGrade;
    private boolean aboutFamily;

    public Student(String surname, int[] marks, int salary, String group, boolean aboutFamily) {
        this.surname = surname;
        this.marks = marks;
        this.salary = salary;
        this.group = group;
        this.avgGrade = getAvgGrade();
        this.aboutFamily = aboutFamily;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public double getAvgGrade() {
        int sum = 0;
        for (int i = 0; i < marks.length; i++) {
            sum += marks[i];
        }
        return (double)sum / 3; // не откидываем дробную часть, переобр в дабл
    }


    public boolean isAboutFamily() {
        return aboutFamily;
    }

    public void setAboutFamily(boolean aboutFamily) {
        this.aboutFamily = aboutFamily;
    }

    @Override
    public int hashCode() {
        int result = 19;
        result = 31 * result + surname.hashCode();
        result = 31 * result + marks.hashCode();
        result = 31 * result + salary;
        result = 31 * result + group.hashCode();
        return result;
    }
// 1 override equals и закомитить
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    // Students st = (Students) obj;
    // return name.equals(st.name) && surname.equals(st.surname);

    @Override
    public String toString() {
        return "Фамилия - " + surname +
                " Оценки - " + Arrays.toString(marks) +
                " Зарплата - " + salary +
                " Группа - " + group +
                " Средний балл - " + avgGrade +
                " Льготность - " + aboutFamily;
    }
}
