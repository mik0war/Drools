package ru.mirea;

public class Client {
    private int age;
    private int experienceMonth;
    private double salary;

    public Client(int age, int experienceMonth, double salary) {
        this.age = age;
        this.experienceMonth = experienceMonth;
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public int getExperienceMonth() {
        return experienceMonth;
    }

    public double getSalary() {
        return salary;
    }
}
