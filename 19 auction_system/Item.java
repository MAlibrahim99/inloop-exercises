import java.util.ArrayList;
import java.util.List;

public class Item {
    private String name;
    private String description;
    private long minPrice;
    private Bid highestBid;
    private List<Bid> allBids;

    public Item(String name, String description, long minPrice) {
        if (name == null || description == null) throw new NullPointerException();
        if (minPrice <= 0 || name.equals("") || description.equals("")) throw new IllegalArgumentException();
        allBids = new ArrayList<Bid>();
        this.name = name;
        this.description = description;
        this.minPrice = minPrice;
//        this.highestBid = new Bid(new Person("seller"), minPrice);
    }

    public void addBid(Person bidder, long price) {
        if (bidder == null) throw new NullPointerException();
        if(price <= 0) throw new IllegalArgumentException();
        if (price < minPrice) return;
        if(price >= minPrice && highestBid == null ) {
            allBids.add(new Bid(bidder, price));
            highestBid = new Bid(bidder, price);
        }else{
//            allBids.add(new Bid(bidder, price));
            if(price > highestBid.getPrice()) {
                highestBid = new Bid(bidder, price);
                allBids.add(highestBid);
            }}

//        for(Bid bid: allBids){
//            if(bid.getBidder().toString().equals(bidder.toString())){
//                allBids.remove(bid);
//                allBids.add(temp);
//                return;
//            }
        }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Bid getHighestBid() {
        return highestBid;
    }

    public List<Bid> getAllBids() {
        return allBids;
    }

    @Override
    public String toString() {
        return name + ": " + description + " (minimum bidding price: " + minPrice
                + " EUR)";
        /*<name>: <description> (minimum bidding price: <minPrice> EUR)*/

    }
}
