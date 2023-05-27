import java.util.ArrayList;
import java.util.List;

public abstract class ComplexPricing implements ISalePricing{

    // pricings should have at least one element inside
    private List<ISalePricing> pricings;

    public ComplexPricing(ISalePricing pricing) {
        if(pricing == null) throw new NullPointerException();
//        if(pricings.size() == 0) throw new IllegalArgumentException();
        this.pricings = new ArrayList<>();
        this.add(pricing);
    }

    public void add(ISalePricing pricing){
        if(pricing == null) throw new NullPointerException();
        pricings.add(pricing);
    }

    public List<ISalePricing> getPricings() {
        return pricings;
    }
}
