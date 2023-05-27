import java.util.*;

public abstract class Stock {
    private Map<Part, Integer> parts = new HashMap<>();
    private List<StockObserver> observers = new ArrayList<>();

    public int getCount(Part part) {
        if (part == null) {
            throw new NullPointerException();
        }
        if(parts.containsKey(part))
            return parts.get(part);
        return -1;
    }

    public boolean remove(Part part, int amount) {
        if (part == null) throw new NullPointerException();
        if (amount <= 0) throw new IllegalArgumentException();

        if (parts.containsKey(part)) {
            if (parts.get(part) < amount) {
                return false;
            } else {
                parts.replace(part, parts.get(part) - amount);
                notifyPartCount(part);
                return true;
            }
        }
        return false;
    }

    public boolean insert(Part part, int amount) {
        if (part == null) throw new NullPointerException();
        if (amount <= 0) throw new IllegalArgumentException();
        if(parts.containsKey(part))
            parts.replace(part, amount + parts.get(part));
        else parts.put(part, amount);
        notifyPartCount(part);
        return true;
    }

    public void addObserver(StockObserver observer) {
        if(observer == null) throw new NullPointerException();
        observers.add(observer);
    }

    private void notifyPartCount(Part part) {
        observers.stream().forEach(observer -> observer.onPartCountChanged(part,getCount(part)));
    }

}
