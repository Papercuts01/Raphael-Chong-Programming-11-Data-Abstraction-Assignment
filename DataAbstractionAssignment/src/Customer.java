import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber = 1000;

    public ArrayList<Deposit> getDeposits() {
        return deposits;
    }

    private ArrayList<Deposit> deposits = new ArrayList<>();

    public ArrayList<Withdraw> getWithdraws() {
        return withdraws;
    }

    private ArrayList<Withdraw> withdraws = new ArrayList<>();

    public double getCheckBalance() {
        return checkBalance;
    }

    private double checkBalance;

    public double getSavingBalance() {
        return savingBalance;
    }

    private double savingBalance;
    private double savingRate;
    private int defaultAccountNum;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    Customer(){
            name = "Place Holder";
           defaultAccountNum = accountNumber;
            accountNumber++;
            checkBalance = 0;
            savingBalance = 0;



    }
    Customer(String name, int accountNumber, double checkBalance, double savingBalance){
        this.name = name;
        this.accountNumber = accountNumber;
        accountNumber++;
       this.checkBalance = checkBalance;
       this.savingBalance = savingBalance;


    }
        //Requires: double, date, String
        //Modifies: this, checkBalance, savingBalance
        //Effects:Adds double to another double which is specified by a string
    public double deposit(double amt, Date date, String account){
        if(account.equals(Customer.CHECKING)){
            checkBalance += amt;
            deposits.add(new Deposit(amt,date,CHECKING));
            System.out.println("Deposit: $" + amt + " Date: " + date + " into account: " + account);

        } else if(account.equals(Customer.SAVING)){
            savingBalance += amt;
            deposits.add(new Deposit(amt,date,SAVING));
            System.out.println("Deposit: $" + amt + " Date: " + date + " into account: " + account);
        }



        return 0;
    }
    //Requires: double, date, String
    //Modifies: this, checkBalance, savingBalance
    //Effects:Subtracts double to another double which is specified by a string
    public double withdraw(double amt, Date date, String account){

        if(account.equals(CHECKING)){
            if(amt > checkBalance) {
                System.out.println("OVERDRAFT");
            } else {checkBalance -= amt;
                withdraws.add(new Withdraw(amt,date,account));
                 System.out.println("Withdrawal: $" + amt + " Date: " + date + " from account: " + account);}
        } else if(account.equals(SAVING)){
            if(amt > savingBalance){
                System.out.println("OVERDRAFT");
            }else {savingBalance -= amt;
                withdraws.add(new Withdraw(amt,date,account));
                System.out.println("Withdrawal: $" + amt + " Date: " + date + " from account: " + account);}
        }
        return 0;
    }
    //Requires: double, string
    //Modifies: this
    //Effects: checks if a double is more of less than another double which is specified by a string
    private boolean checkOverdraft(double amt, String account){
        if(account.equals(CHECKING)){
            if(amt > checkBalance){
                System.out.println("OVERDRAFT");
            }
        } else if(account.equals(SAVING)){
            if(amt > savingBalance){
                System.out.println("OVERDRAFT");
            }
        }
        return false;
    }




    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

}
