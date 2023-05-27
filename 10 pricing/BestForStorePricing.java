public class BestForStorePricing extends ComplexPricing{

    public BestForStorePricing(ISalePricing pricing){
        super(pricing);
    }

    @Override
    public long getTotal(Sale sale) {
        if(sale == null) throw new NullPointerException();
//        sale.
        return   super.getPricings().stream().mapToLong(v -> v.getTotal(sale)).max().orElse(0);
    }
}
