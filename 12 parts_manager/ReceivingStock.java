public class ReceivingStock extends Stock{
    private int minStockItem;
    private int maxStockItem;
//    private List<StockObserver> observers;

    public ReceivingStock(int minStockItem, int maxStockItem) {
        if(minStockItem < 0 || maxStockItem <= minStockItem) throw new IllegalArgumentException();
        this.minStockItem = minStockItem;
        this.maxStockItem = maxStockItem;
//        this.observers = new ArrayList<StockObserver>();
    }

    public int getMinStockItems() {
        return minStockItem;
    }

    public int getMaxStockItems() {
        return maxStockItem;
    }

    @Override
    public boolean insert(Part part, int amount) {
        if (part == null) throw new NullPointerException();
        if (amount <= 0) throw new IllegalArgumentException();

        if (super.getCount(part) < maxStockItem && amount<= freePlace(part)) {
            return super.insert(part, amount);
        }
        return false;
    }



//        if (super.getCount(part) > 0) {
//            if(freePlace(part) >= amount)
//                return super.insert(part, amount);
//            else return false;
//            }
//        else if(super.getCount(part) == 0){
//            if(amount <= maxStockItem) {
//                return super.insert(part, amount);
//            }
//        }else
//                return false;
//        return false;
//    }

    @Override
    public boolean remove(Part part, int amount){
        if (part == null) throw new NullPointerException();
        if (amount <= 0) throw new IllegalArgumentException();
        return super.remove(part, amount);
    }
    private int freePlace(Part part){
        return maxStockItem - super.getCount(part);
    }

}
