import ru.mirea.*;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import static org.junit.Assert.*;

public class MortgageTest {

    @Test
    public void test_differentiated(){
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("ksession-rules");

        Mortgage mortgage = new Mortgage(
                new Credit(1500000, 9.6, 240, PaymentType.DIFFERENTIATED),
                new Client(22, 35, 50000));

        kSession.insert(mortgage);
        kSession.fireAllRules();

        assertEquals(0.008, mortgage.getMonthlyInterest(), 0.001);
        assertEquals(18250, mortgage.getMonthlyPayments()[0].getMonthlyPayment(), 0.001);
        assertEquals(6250.0, mortgage.getMonthlyPayments()[0].getMainPayment(), 0.001);
        assertEquals(2946000.0, mortgage.getCredit().getTotalSum(), 0.001);
        assertTrue(mortgage.isApproved());
    }

    @Test
    public void test_annuity(){
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("ksession-rules");

        Mortgage mortgage = new Mortgage(
                new Credit(1500000, 9.6, 240, PaymentType.ANNUITY),
                new Client(18, 35, 15000));

        kSession.insert(mortgage);
        kSession.fireAllRules();

        assertEquals(0.008, mortgage.getMonthlyInterest(), 0.001);
        assertEquals(14080.06, mortgage.getMonthlyPayments()[0].getMonthlyPayment(), 0.01);
        assertEquals(2080.06, mortgage.getMonthlyPayments()[0].getMainPayment(), 0.01);
        assertEquals(3379215.66, mortgage.getCredit().getTotalSum(), 0.01);
        assertFalse(mortgage.isApproved());
    }
}
