package edu.mephi.lab_2;

import lombok.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@Setter
@Getter
@Builder
@AllArgsConstructor
@ToString
public class User {
    private int id;
    private int age;
    private String firstName;
    private String lastName;
    private String country;

    public static void printStudentsByLastName(List<User> users) {
        users.stream()
                .sorted(Comparator.comparing(User::getLastName))
                .forEach(System.out::println);
    }

    public static void printStudentsByAge(List<User> users) {
        users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .forEach(System.out::println);
    }

    public static Optional<Boolean> checkAge(List<User> users) {
        if (users.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(users.stream()
                .allMatch(user -> user.getAge() > 7));
    }

    public static OptionalDouble calculateAverageAge(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average();
    }

    public static long countUniqueCountries(List<User> users) {
        return users.stream()
                .map(User::getCountry)
                .distinct()
                .count();
    }
}
