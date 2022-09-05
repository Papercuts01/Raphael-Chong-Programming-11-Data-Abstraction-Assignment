import java.util.Date;

public class Deposit {
    public double getAmount() {
        return amount;
    }
    private double amount;
    private Date date;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    private String account;
        //Requires: new Deposit
        //modifies: this
        //effects: when you print a new Deposit toString overrides, and it can print whatever you want
    public String toString(){
        return "Deposit: $" + amount + " Date: " + date + " into account: " + account;
    }


      Deposit(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;


    }



}
