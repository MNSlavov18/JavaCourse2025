package Homework;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class Manager {
    private String name;
    private LocalDate hireDate;

    public Manager(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(int year, int month, int day) {
        LocalDate date = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();

        if (date.isAfter(today)) {
            this.hireDate = LocalDate.of(2020, 1, 1);
        } else {
            this.hireDate = date;
        }
    }

    public int numberOfYearsInCompanyTill(int year, int month, int day) {
        LocalDate givenDate = LocalDate.of(year, month, day);
        return (int) ChronoUnit.YEARS.between(hireDate, givenDate);
    }
}

public class MangersClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int hireYear = scanner.nextInt();
        int hireMonth = scanner.nextInt();
        int hireDay = scanner.nextInt();
        int currentYear = scanner.nextInt();
        int currentMonth = scanner.nextInt();
        int currentDay = scanner.nextInt();

        Manager manager = new Manager(name);
        manager.setHireDate(hireYear, hireMonth, hireDay);

        System.out.println(manager.getHireDate());
        System.out.println(manager.numberOfYearsInCompanyTill(currentYear, currentMonth, currentDay));

        scanner.close();
    }
}