public class Noble extends Inhabitant {
    private int extraTax = 20;
    @Override
    public int tax(){
        if(taxableIncome()<209) return extraTax;
        return (taxableIncome()/getTotalTax());
    }
}
