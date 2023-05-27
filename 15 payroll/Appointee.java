public class Appointee extends Employee{
    private int payday;
    private int hoursPerMonth;
    private double payPerHour;

    public Appointee(String id, int payday, int hoursPerMonth, double payPerHour) {
        super(id);
        if(payday <=0 || payday > 30 || hoursPerMonth <=0 || payPerHour <=0) throw new IllegalArgumentException();
        this.payday = payday;
        this.hoursPerMonth = hoursPerMonth;
        this.payPerHour = payPerHour;
    }

    @Override
    public boolean isPayday(int dayOfMonth) {
        if(dayOfMonth <1 || dayOfMonth > 30) throw new IllegalArgumentException();
        return payday == dayOfMonth;
    }

    @Override
    public double calculatePay() {
        return Math.round(hoursPerMonth* payPerHour*100.0)/100.0;
    }

    @Override
    public double calculateDeductions() {
        return (calculatePay()*40)/100.0;
    }
}
