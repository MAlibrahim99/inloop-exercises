public class Payroll {
    private int payday;
    private PayrollDisposition disposition;

    public Payroll(PayrollDisposition disposition, int payday) {
        if(payday <1 || payday >30) throw new IllegalArgumentException();
        if(disposition == null) throw new NullPointerException();
        this.payday = payday;
        this.disposition = disposition;
    }

    public void doPayroll(PayrollDB db){
        db.getEmployeeList().forEach(employee -> {
            try{if(employee.isPayday(payday))
                disposition.sendPayment(employee,employee.calculatePay() - employee.calculateDeductions());
            }catch (UnpayableEmployeeException ignored){}
//            disposition.sendPayment(employee,-employee);
        });
//        disposition.sendPayment();
    }
}
