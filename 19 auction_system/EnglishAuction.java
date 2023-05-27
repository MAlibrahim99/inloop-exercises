public class EnglishAuction extends Auction{
    @Override
    public String generateItemString(Item item) {
        if(item == null) throw new NullPointerException();
        Item temp ;
        if(getAllItems().contains(item)) {
            temp = getAllItems().get(getAllItems().indexOf(item));
            if(temp.getHighestBid() != null)
            return temp.toString() +"\nHighest bid: " +
                            temp.getHighestBid().
                            toString();
            else return item.toString() + "\nNo bids placed";
        }
        return null;
    }
}
