public class Purchasing implements StockObserver{
    private ReceivingStock receivingStock;

    public Purchasing(ReceivingStock stock) {
        if(stock == null) throw new NullPointerException();
        this.receivingStock = stock;
    }

    public void buy(Part part, int count){
        if(count < 1) throw new IllegalArgumentException();
        receivingStock.insert(part,count);
    }

    public ReceivingStock getStock() {
        return receivingStock;
    }

    @Override
    public void onPartCountChanged(Part part, int count) {
        if(receivingStock.getCount(part) < receivingStock.getMinStockItems()){
            buy(part,receivingStock.getMaxStockItems() - receivingStock.getCount(part));
        }
    }


}
