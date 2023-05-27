public abstract class ProjectItem {

    private String name;
    private String details;
    private double rate;

    public ProjectItem(String name, String details, double rate) {
        if(name == null || details == null){
            throw new NullPointerException();
        }
        if(name.equals("") || rate <= 0 || details.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.details = details;
        this.rate = rate;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public long getCostEstimate(){
        double temp = getTimeRequired() * rate;
        temp = Math.round(temp);

        return (long) temp + getMaterialCost() ;
    }

    public abstract double getTimeRequired();
    public abstract long getMaterialCost();
}
