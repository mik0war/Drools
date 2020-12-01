package ru.mirea;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class Mortgage {
    private double monthlyInterest;
    private MonthlyPayment[] monthlyPayments;
    private boolean isApproved;

    private Credit credit;
    private Client client;

    public Mortgage(Credit credit, Client client) {
        this.credit = credit;
        this.client = client;
        this.monthlyPayments = new MonthlyPayment[this.credit.getTerm()];
    }

    public double getMonthlyInterest() {
        return monthlyInterest;
    }

    public Credit getCredit() {
        return credit;
    }

    public Client getClient() {
        return client;
    }

    public void setMonthlyInterest(Double monthlyInterest) {
        this.monthlyInterest = monthlyInterest;
    }

    public MonthlyPayment[] getMonthlyPayments() {
        return monthlyPayments;
    }

    public void setMonthlyPayment(MonthlyPayment monthlyPayment, int index) {
        this.monthlyPayments[index] = monthlyPayment;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public static void main(String[] args) {
        try {
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-rules");

            Mortgage mortgage = new Mortgage(
                    new Credit(1500000, 9.6, 240, PaymentType.ANNUITY),
                    new Client(22, 35, 50000));

            kSession.insert(mortgage);
            kSession.fireAllRules();

        } catch (Throwable t){
            t.printStackTrace();
        }
    }
}
