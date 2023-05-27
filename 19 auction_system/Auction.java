import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public abstract class Auction {
    private boolean closed;
    private List<Item> allItems;
    private List<Person> bidders;

    public Auction() {
        this.closed = false;
        allItems = new ArrayList<>();
        bidders = new ArrayList<>();
    }

    public void addBid(Item bidItem, String nameOfBid, long price) {
        if(closed) throw new IllegalStateException();
        if (bidItem == null || nameOfBid == null) throw new NullPointerException();
        if (nameOfBid.equals("") || price <= 0) throw new IllegalArgumentException();
        if(!allItems.contains(bidItem)) throw new NoSuchElementException();
        if (allItems.contains(bidItem)) {
            try {
                allItems.stream().
                        filter(item -> item.getName().equals(bidItem.getName())).
                        findAny().orElse(null)
                        .addBid(new Person(nameOfBid), price);
            }catch (NullPointerException ignore){}
        }
    }

    public String closeAuction() {
        if(closed) throw new IllegalStateException();
        closed = true;
        return generateItemListString();
    }
    public String generateItemListString(){

        StringBuilder builder = new StringBuilder();
        for (Item it: allItems
             ) {
            if(allItems.indexOf(it) == allItems.size()-1)
                builder.append(generateItemString(it));
            else
                builder.append(generateItemString(it))
                        .append("\n");
        }
        return builder.toString();
    }

    public String generateAllBidsString(Item item) {
        if (item == null) throw new NullPointerException();

        List<String> temp = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        allItems.get(allItems.indexOf(item)).getAllBids().forEach(e-> {
            temp.add(e.toString());
        });

        for(String str : temp){
            if (temp.indexOf(str) == temp.size()-1)
                builder.append(str);
            else
            builder.append(str).append("\n");
        }
        return "All bids:\n" + builder.toString();

    }
    public abstract String generateItemString(Item item);

    public void registerItem(Item item){
        if(item == null) throw new NullPointerException();
        if(closed) throw new IllegalStateException();
        for (Item i: allItems
             ) {
            if(i.getName().equalsIgnoreCase(item.getName()))
                throw new IllegalArgumentException();
        }
        if(!allItems.contains(item))
            allItems.add(item);
        else System.out.println("There is already an item with the same specifications");
    }

    public List<Item> getAllItems(){
        return allItems;
    }


}
