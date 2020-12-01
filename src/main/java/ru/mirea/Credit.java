package ru.mirea;

public class Credit {
    private double sum;
    private double totalSum;
    private double remainder;
    private double yearPercent;
    private int term;
    private PaymentType paymentType;

    public Credit(double sum, double yearPercent,int term, PaymentType paymentType) {
        this.remainder = this.sum = sum;
        this.yearPercent = yearPercent;
        this.term = term;
        this.paymentType = paymentType;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public int getTerm() {
        return term;
    }

    public double getReminder() {
        return remainder;
    }

    public void setRemainder(double sum) {
        this.remainder = sum;
    }

    public double getYearPercent() {
        return yearPercent;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }
}
