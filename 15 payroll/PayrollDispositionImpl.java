import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PayrollDispositionImpl implements PayrollDisposition{

    private Map<Employee, Double> payments;

    public PayrollDispositionImpl(){
        this.payments = new HashMap<Employee, Double>();
    }

    public double getTotal(){
        return payments.values().stream().mapToDouble(value -> value).sum();
    }

    public double getAverage(){
        return payments.values().stream().mapToDouble(value -> value).average().orElse(0.0);
    }

    public Map<Employee, Double> getPayments(){
        return payments;
    }

    @Override
    public void sendPayment(Employee empl, double payment) {
        if(empl == null) throw new NullPointerException();
        if(payment <= 0) throw new IllegalArgumentException();

        if(payments.containsKey(empl))
            payments.put(empl,payment + payments.get(empl));
//            throw new IllegalStateException("there is already an employee with "+ empl.getId());
        payments.put(empl, payment);

    }

}
