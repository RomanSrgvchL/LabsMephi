package edu.mephi.lab_1;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class Util {
    public static List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        try (Scanner sc = new Scanner(Path.of("src", "main", "resources", "students.txt"))) {
            while (sc.hasNextLine()) {
                students.add(Student.builder()
                        .name(sc.next())
                        .group(sc.next())
                        .course(sc.nextInt())
                        .grades(sc.next().chars().map(Character::getNumericValue).toArray())
                        .build());
            }
        } catch (IOException e) {
            System.out.println("Файл students.txt не найден");
            System.exit(1);
        }
        return students;
    }
}
