package edu.mephi.lab_1;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Iterator;
import java.util.List;

@Setter
@Getter
@Builder
public class Student {
    private String name;
    private String group;
    private int course;
    private int[] grades;

    public Student(String name, String group, int course, int[] grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades.clone();
    }

    public int[] getGrades() {
        return grades.clone();
    }

    public void setGrades(int[] grades) {
        this.grades = grades.clone();
    }

    public int getGrade(int index) {
        return grades[index];
    }

    public void setGrade(int index, int grade) {
        grades[index] = grade;
    }

    public static void updateStudents(List<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getAverageGrade() < 3) {
                iterator.remove();
            } else {
                student.course++;
            }
        }
    }

    public double getAverageGrade() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }

    public static void printStudents(List<Student> students, int course) {
        boolean isEmpty = true;
        for (var student : students) {
            if (student.getCourse() == course) {
                isEmpty = false;
                System.out.println(student);
            }
        }
        if (isEmpty) {
            System.out.println("На " + course + " курсе не обучается ни один студент");
        }
    }

    @Override
    public String toString() {
        return "|" + name + ", " + group + "|";
    }
}
