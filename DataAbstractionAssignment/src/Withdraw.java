import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;

    Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }
    //Requires: new Withdraw
    //Modifies: this
    //Effects: when you print a new Withdrawal, toString overrides, and it can print whatever you want
    public String toString(){
        return "Withdrawal: $" + amount + " Date: " + date + " from account: " + account;
    }
}
