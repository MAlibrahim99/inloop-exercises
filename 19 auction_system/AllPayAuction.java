public class AllPayAuction extends Auction{
    @Override
    public String generateItemString(Item item) {
        if(item == null) throw new NullPointerException();
//        Item item1 = getAllItems().stream().filter(i -> getAllItems().contains(i)).findFirst().
//                get();
        Item item1 ;
        if(getAllItems().contains(item)) {
            item1 = getAllItems().get(getAllItems().indexOf(item));
            if(item1.getAllBids().size()>0)
                return item1.toString() + "\nHighest bid: " +
                        item1.getHighestBid().toString()
//                        "\nAll bids:\n" +
                        +
                        "\n"+
                        generateAllBidsString(item1);
            else return item.toString() + "\nNo bids placed";
        }

        return "item is not found";
    }
}
