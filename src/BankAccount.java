import java.math.BigDecimal;
import java.util.Objects;

public class BankAccount {
    private double balance;
    private AccountOwner accountOwner;
    private long accountNumber;

    public BankAccount(AccountOwner accountOwner,
                        double balance) {
        this.balance = balance;
        this.accountOwner = accountOwner;

        this.accountNumber = setAccountNumber(accountNumber);
    }

    public int deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            return 1;
        }
        else {
            return 2;
        }
    }

    public int withdraw(double amount) {
        if (amount < 0) {
            return 2;
        }
        else if (amount > balance) {
            return 3;
        }
        else {
            balance -= amount;
            return 1;
        }
    }

    //make money go into other account
    public int transfer(long account, double amount) {
        if (amount < 0) {
            return 2;
        }
        else if (amount > balance) {
            return 3;
        }
        else if (ATM.lookup(account) == null) {
            return 4;
        }
        else {
            withdraw(amount);
            Objects.requireNonNull(ATM.lookup(account)).balance += amount;
            return 1;
        }
    }

    public String getMaskedAccountNumber() {
        String accountString = String.valueOf(this.accountNumber);
        return "****" + accountString.substring(5);
    }

    public long setAccountNumber(long account) {
         if(ATM.lookup(account) == null) {
            long newNumber = 0;
                for (int i = 0; i < 9; i++) {
                    int random = (int) Math.floor(Math.random() * 10);
                    newNumber += random * Math.pow(10, i);
                }
            return newNumber;
        }
        return this.accountNumber;
    }

    public String getFormattedBalance(){
        return String.format("$%,.2f", balance);
    }

    public java.math.BigDecimal validateBalance(double balance) {
        if (balance < 0) {
            return BigDecimal.ZERO;
        }
        else {
            return new BigDecimal(balance);
        }
    }

    public long getAccountNumber(){
        return accountNumber;
    }


    public AccountOwner getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(AccountOwner accountOwner) {
        this.accountOwner = accountOwner;
    }

    public java.math.BigDecimal getBalance() {
        return validateBalance(balance);
    }
}
