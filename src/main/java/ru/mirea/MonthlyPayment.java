package ru.mirea;

public class MonthlyPayment{
    private double percentPayment;
    private double mainPayment;

    public MonthlyPayment() {
        this.mainPayment = 0.0;
        this.percentPayment = 0.0;
    }

    public MonthlyPayment(Double percentPayment, Double mainPayment) {
        this.percentPayment = percentPayment;
        this.mainPayment = mainPayment;
    }

    public double getPercentPayment() {
        return percentPayment;
    }

    public void setPercentPayment(Double percentPayment) {
        this.percentPayment = percentPayment;
    }

    public double getMainPayment() {
        return mainPayment;
    }

    public void setMainPayment(Double mainPayment) {
        this.mainPayment = mainPayment;
    }

    public double getMonthlyPayment(){
        return this.percentPayment + this.mainPayment;
    }

    @Override
    public String toString() {
        return "Ежемесячная выплата: " + getMonthlyPayment() +
                " (Проценты: " + percentPayment +
                ", Основная часть: " + mainPayment +
                ')';
    }
}
