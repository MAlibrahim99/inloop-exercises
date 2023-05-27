public class Bid {
    private long price;
    private Person bidder;

    public Bid(Person bidder, long price) {
        if(price <= 0) throw new IllegalArgumentException();
        if(bidder == null) throw new NullPointerException();
        this.price = price;
        this.bidder = bidder;
    }

    public long getPrice() {
        return price;
    }

    public Person getBidder() {
        return bidder;
    }

    @Override
    public String toString(){
        return price + " EUR by " + bidder.getName();
    }


}
