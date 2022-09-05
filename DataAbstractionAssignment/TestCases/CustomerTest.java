import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import java.util.Date;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class CustomerTest {
    Date thisDate = new Date();
    SimpleDateFormat dateForm = new SimpleDateFormat("");

    Customer CustomerTest;

    @Before
    public void setup() {
        CustomerTest = new Customer();
    }


    @Test
    public void testCustomerDeposit() {

        CustomerTest.deposit(100, thisDate, Customer.CHECKING);
        assertTrue(CustomerTest.getCheckBalance() == 100);
        System.out.println(CustomerTest.getCheckBalance());
        assertEquals("[Deposit: $100.0 Date: " + thisDate + " into account: Checking]", CustomerTest.getDeposits().toString());


        CustomerTest.deposit(12, thisDate, Customer.CHECKING);
        assertTrue(CustomerTest.getCheckBalance() == 112);
        System.out.println(CustomerTest.getCheckBalance());
        assertEquals("[Deposit: $100.0 Date: " + thisDate + " into account: Checking, Deposit: $12.0 Date: " + thisDate + " into account: Checking]", CustomerTest.getDeposits().toString());

        CustomerTest.deposit(100, thisDate, Customer.SAVING);
        assertTrue(CustomerTest.getSavingBalance() == 100);
        System.out.println(CustomerTest.getSavingBalance());
        assertEquals("[Deposit: $100.0 Date: " + thisDate + " into account: Checking, Deposit: $12.0 Date: " + thisDate + " into account: Checking, Deposit: $100.0 Date: " + thisDate + " into account: Saving]", CustomerTest.getDeposits().toString());

        CustomerTest.deposit(12, thisDate, Customer.SAVING);
        assertTrue(CustomerTest.getSavingBalance() == 112);
        System.out.println(CustomerTest.getSavingBalance());
        assertEquals("[Deposit: $100.0 Date: " + thisDate + " into account: Checking, Deposit: $12.0 Date: " + thisDate + " into account: Checking, Deposit: $100.0 Date: " + thisDate + " into account: Saving, Deposit: $12.0 Date: " + thisDate + " into account: Saving]", CustomerTest.getDeposits().toString());

    }

    @Test
    public void testCustomerWithdraw() {
        CustomerTest.deposit(200, thisDate, Customer.CHECKING);
        System.out.println(CustomerTest.getCheckBalance());
        CustomerTest.deposit(200, thisDate, Customer.SAVING);
        System.out.println(CustomerTest.getSavingBalance());//initial deposit


        CustomerTest.withdraw(99, thisDate, Customer.CHECKING);
        assertTrue(CustomerTest.getCheckBalance() == 101);
        System.out.println(CustomerTest.getCheckBalance());
        assertEquals("[Withdrawal: $99.0 Date: " + thisDate + " from account: Checking]", CustomerTest.getWithdraws().toString());


        CustomerTest.withdraw(1, thisDate, Customer.CHECKING);
        assertTrue(CustomerTest.getCheckBalance() == 100);
        System.out.println(CustomerTest.getCheckBalance());
        assertEquals("[Withdrawal: $99.0 Date: " + thisDate + " from account: Checking, Withdrawal: $1.0 Date: " + thisDate + " from account: Checking]", CustomerTest.getWithdraws().toString());

        CustomerTest.withdraw(99, thisDate, Customer.SAVING);
        assertTrue(CustomerTest.getSavingBalance() == 101);
        System.out.println(CustomerTest.getSavingBalance());
        assertEquals("[Withdrawal: $99.0 Date: " + thisDate + " from account: Checking, Withdrawal: $1.0 Date: " + thisDate + " from account: Checking, Withdrawal: $99.0 Date: " + thisDate + " from account: Saving]", CustomerTest.getWithdraws().toString());

        CustomerTest.withdraw(1, thisDate, Customer.SAVING);
        assertTrue(CustomerTest.getSavingBalance() == 100);
        System.out.println(CustomerTest.getSavingBalance());
        assertEquals("[Withdrawal: $99.0 Date: " + thisDate + " from account: Checking, Withdrawal: $1.0 Date: " + thisDate + " from account: Checking, Withdrawal: $99.0 Date: " + thisDate + " from account: Saving, Withdrawal: $1.0 Date: " + thisDate + " from account: Saving]", CustomerTest.getWithdraws().toString());


    }

    @Test
    public void testCustomerWithdrawOverdraft() {
        CustomerTest.deposit(100, thisDate, Customer.CHECKING);
        CustomerTest.withdraw(101, thisDate, Customer.CHECKING);

    }

    @Test
    public void testDepositToString() {
        Deposit depositTest = new Deposit(100, thisDate, Customer.CHECKING);
        System.out.println(depositTest);
        assertEquals("Deposit: $100.0 Date: " + thisDate + " into account: Checking", depositTest.toString());
    }

    @Test
    public void testWithdrawToString() {
        Withdraw withdrawTest = new Withdraw(100, thisDate, Customer.CHECKING);
        System.out.println(withdrawTest);
        assertEquals("Withdrawal: $100.0 Date: " + thisDate + " from account: Checking", withdrawTest.toString());

    }
    @Test
    public void testDemonstration(){
        CustomerTest.deposit(100,thisDate,Customer.CHECKING);
        System.out.println(CustomerTest.getCheckBalance());
        CustomerTest.deposit(355.67,thisDate, Customer.CHECKING);
        System.out.println(CustomerTest.getCheckBalance());
       CustomerTest.withdraw(455.68, thisDate, Customer.CHECKING);

    }
}
