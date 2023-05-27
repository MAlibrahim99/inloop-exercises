import java.util.Objects;

public class BankAccount {
    private double balance = 0.0;
    private double lineOfCredit;
    private String accountNumber;
    private AccountState state;
    private final AccountState POSITIVE = new Positive();
    private final AccountState NEGATIVE = new Negative();
    private final AccountState FROZEN = new Frozen();
    private final AccountState CLOSED = new Closed();


    public BankAccount(String accountNumber, double lineOfCredit) {
        Objects.requireNonNull(accountNumber);
        if(accountNumber.equals("")) throw new IllegalArgumentException();
        this.accountNumber = accountNumber;
        this.lineOfCredit = lineOfCredit;
        state = new Positive();
    }

    public boolean payIn(double amount) {
        if(amount <= 0.0) throw new IllegalArgumentException();
            return state.payIn(amount);
    }

    public boolean payOff(double amount) {
        if(amount <= 0.0) throw new IllegalArgumentException();
        return state.payOff(amount);
    }

    public boolean close() {
        if (balance == 0.0) {
            state = CLOSED;
            return true;
        } else if (balance < 0.0 || balance > 0.0)
            return false;
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public String getState() {
        return state.getClass().getSimpleName();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void printBalance() {
        state.printBalance();
    }

    public void payInterest() {
        state.payInterest();
    }
    //**********************************************
    // ACCOUNT STATE
    abstract class AccountState {
        public boolean payIn(double amount) {
            throw new UnsupportedOperationException();
        }

        public boolean payOff(double amount) {
            throw new UnsupportedOperationException();
        }
        @Override
        public String toString() {
            return AccountState.class.getSimpleName();
        }

        public void payInterest() {

        }

        public abstract void printBalance();
    }

    class Positive extends AccountState {

        @Override
        public boolean payIn(double amount) {
            if (amount <= 0) throw new IllegalArgumentException();

            balance += amount;
            return true;
        }

        public boolean payOff(double amount) {
            if (amount <= 0) throw new IllegalArgumentException();
            if (balance - amount >= 0) {
                balance -= amount;
                return true;
            } else {
                if (balance + lineOfCredit - amount > 0) {
                    state = NEGATIVE;
                    balance -= amount;
                    return true;
                } else if (balance + lineOfCredit - amount == 0) {
                    state = FROZEN;
                    balance = -lineOfCredit;
                    return true;
                } else
                    return false;
            }
        }

        @Override
        public void printBalance() {
            System.out.println("Balance is POSITIVE" + ": +" + getBalance() + ".");
        }

        @Override
        public String toString() {
            return Positive.class.getSimpleName();
        }

        @Override
        public void payInterest(){
            balance += Math.round(balance * 100.0) * 1.0/10000.0;
        }
    }

    class Negative extends AccountState {

        public boolean payIn(double amount) {
            if (amount <= 0) throw new IllegalArgumentException();
            balance += amount;
            if (balance >= 0.0) {
                state = POSITIVE;
            }
            return true;
        }

        public boolean payOff(double amount) {
            if (amount <= 0) throw new IllegalArgumentException();
            if (balance - amount > -lineOfCredit) {
                balance -= amount;
                return true;
            } else {
                if (balance - amount == -lineOfCredit) {
                    state = FROZEN;
                    balance = -lineOfCredit;
                    return true;
                } else {
                    return false;
                }
                }
            }
//
        @Override
        public void payInterest(){
            balance = balance  + Math.round(balance * 100.0)* 3.0/10000.0;
            if(balance < -lineOfCredit)
                state = FROZEN;
        }

        @Override
        public void printBalance() {
            System.out.println("Balance is NEGATIVE" + ": " + getBalance() + ".");

        }

        @Override
        public String toString() {
            return "Negative";
        }
    }

    class Frozen extends AccountState {
        @Override
        public boolean payIn(double amount){
            if(amount<=0) throw new IllegalStateException();

            balance += amount;
            if(balance > - lineOfCredit && balance < 0.0){
                state = NEGATIVE;
                return true;
            }
            if(balance >=0.0){
                state = POSITIVE;
                return true;
            }
            return false;
        }

        public void payInterest(){

            balance = balance  + Math.round(balance * 100.0)/100.0 * 5.0/100.0;
        }

        @Override
        public void printBalance() {
            System.out.println("Balance is NEGATIVE" + ": " + getBalance() + ". " +
            "You need to pay in money.");
        }
        @Override
        public String toString() {
            return "Frozen";
        }

        @Override
        public boolean payOff(double amount){
            return false;
        }
    }

    class Closed extends AccountState {
        @Override
        public void printBalance() {
            System.out.println("This account is CLOSED. The balance is " + 0 +  ".");
        }
        @Override
        public boolean payIn(double amount){
            return false;
        }
        @Override
        public boolean payOff(double amount){
            return false;
        }

//        @Override
//        public String toString() {
//            return ;
//        }
        @Override
        public void payInterest(){
            throw new IllegalStateException();
        }
    }
}
