package edu.mephi.lab_2;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class Util {
    public static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        try (Scanner sc = new Scanner(Path.of("src", "main", "resources", "users.txt"))) {
            while (sc.hasNextLine()) {
                users.add(User.builder()
                        .id(sc.nextInt())
                        .firstName(sc.next())
                        .lastName(sc.next())
                        .age(sc.nextInt())
                        .country(sc.next())
                        .build());
            }
        } catch (IOException e) {
            System.out.println("Файл students.txt не найден");
            System.exit(1);
        }
        return users;
    }
}
