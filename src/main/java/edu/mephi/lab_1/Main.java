package edu.mephi.lab_1;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Util.getStudents();

        Student.updateStudents(students);

        Scanner sc = new Scanner(System.in);

        System.out.println("0 - Закончить выполнение программы");
        printMenu();
        int course;
        while (true) {
            course = sc.nextInt();
            if (course < 0 || course > 5) {
                System.out.print("Некорректный ввод, попробуйте ещё раз: ");
            } else {
                if (course == 0) {
                    break;
                }
                System.out.println();
                Student.printStudents(students, course);
                System.out.println();
                printMenu();
            }
        }
    }

    public static void printMenu() {
        System.out.print("По какому курсу выводим студентов (1-5): ");
    }
}
