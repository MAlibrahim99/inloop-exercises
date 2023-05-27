
public class Inhabitant {
    private int income;
    private int totalTax = 10;

    public int taxableIncome(){

        return income;
    }

    public int tax(){
        if(taxableIncome()<10 && taxableIncome() >=0)
            return 1;
        return taxableIncome()/totalTax;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        if(income < 0)
            throw new IllegalArgumentException("Value cannot be less than 0");
        this.income = income;
    }
    public int getTotalTax(){
        return totalTax;
    }

}
