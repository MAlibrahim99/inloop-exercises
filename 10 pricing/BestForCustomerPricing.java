import java.util.Comparator;

public class BestForCustomerPricing extends ComplexPricing{

    public BestForCustomerPricing(ISalePricing pricing){
        super(pricing);
    }

    @Override
    public long getTotal(Sale sale) {
        if(sale == null) throw new NullPointerException();
//        super.getPricings().stream().min(e-> e.getTotal(sale));
        return   super.getPricings().stream().mapToLong(v -> v.getTotal(sale)).min().orElse(0);

//                   getAsLong()
//                   min(Comparator.comparing(e -> e.getTotal(sale))).filter(e ->);


    }
}