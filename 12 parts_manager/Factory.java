public class Factory {
    private ReceivingStock receivingStock;
    private Purchasing purchasing;
    public Factory(Purchasing purchasing, ReceivingStock receivingStock){
        if(purchasing == null || receivingStock == null) throw new NullPointerException();
        this.purchasing = purchasing;
        this.receivingStock = receivingStock;
    }

    public ReceivingStock getReceivingStock() {
        return receivingStock;
    }

    public Purchasing getPurchasing() {
        return purchasing;
    }

    public static Part createPart(PartType partType, String id, String name){

        switch(partType){
            case RESOURCE: return new Resource(id,name);
            case SINGLE_COMPONENT: return new SingleComponent(id,name);
            case COMPONENTS: return new Components(id,name);

        }
        return null;
    }
}

