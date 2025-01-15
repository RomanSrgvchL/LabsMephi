package edu.mephi.lab_2;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<User> users = Util.getUsers();

        Scanner sc = new Scanner(System.in);

        printMenu();
        int method;
        while (true) {
            method = sc.nextInt();
            if (method < 0 || method > 5) {
                System.out.print("Некорректный ввод, попробуйте ещё раз: ");
            } else {
                System.out.println();
                switch (method) {
                    case 0:
                        System.exit(0);
                    case 1:
                        User.printStudentsByLastName(users);
                        break;
                    case 2:
                        User.printStudentsByAge(users);
                        break;
                    case 3:
                        Optional<Boolean> ageCheck = User.checkAge(users);
                        if (ageCheck.isPresent()) {
                            System.out.println(ageCheck.get());
                        } else {
                            System.out.println("Список пользователей пустой");
                        }
                        break;
                    case 4:
                        OptionalDouble averageAge = User.calculateAverageAge(users);
                        if (averageAge.isPresent()) {
                            System.out.println(averageAge.getAsDouble());
                        } else {
                            System.out.println("Список пользователей пустой");
                        }
                        break;
                    case 5:
                        System.out.println(User.countUniqueCountries(users));
                        break;
                }
                System.out.println();
                printMenu();
            }
        }
    }

    public static void printMenu() {
        System.out.print("""
                    0 - Закончить выполнение программы
                    1 - Вывести список пользователей, отсортированных по lastName
                    2 - Вывести всех пользователей, отсортированных по age
                    3 - Проверить, что для всех пользователей age > 7
                    4 - Вычислить средний возраст всех пользователей
                    5 - Вывести количество разных стран проживания среди пользователей
                    Выберите номер метода:\s""");
    }
}
