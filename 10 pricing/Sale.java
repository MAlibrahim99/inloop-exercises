public class Sale {
    private long preDiscountTotal;
    private ISalePricing pricing;

    public Sale(long preDiscountTotal, ISalePricing pricing) {
        if(preDiscountTotal < 0L) throw new IllegalArgumentException();
        if(pricing == null) throw new NullPointerException();
        this.preDiscountTotal = preDiscountTotal;
        this.pricing = pricing;
    }

    public long getPreDiscountTotal() {
        return preDiscountTotal;
    }

    // best for costumer or best for store
    public void setPricing(ISalePricing pricing){
        if(pricing == null) throw new NullPointerException();
        this.pricing = pricing;
    }

    public long getTotal(){
//        pricing.get
        return pricing.getTotal(this);
    }
    public static ISalePricing createPricing(DiscountType discountType, double percentage, long discount,
                                             long threshold){
        if(/*!DiscountType.ABSOLUTEDISCOUNT.equals(discountType) && !DiscountType.PERCENTAGEDISCOUNT.equals(discountType)
            */ percentage <0 || percentage > 100 || discount < 0 || threshold < 0)
            throw new IllegalArgumentException();
        if(discountType == null) throw new NullPointerException();
        switch(discountType){
            case ABSOLUTEDISCOUNT: return new AbsoluteDiscountPricing(discount,threshold);
            case PERCENTAGEDISCOUNT: return new PercentageDiscountPricing(percentage);
        }
        return null;
    }
}
