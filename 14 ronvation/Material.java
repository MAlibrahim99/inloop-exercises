public abstract class Material {

    private String name;
    private double price;

    public Material(String name, double price) {
        if(name == null ){
            throw new NullPointerException();
        }
        if(name.equals("") ||  price < 0){
            throw new IllegalArgumentException("");
        }
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPricePerUnit() {
        return price;
    }

    public abstract int getMaterialRequirements(Surface surface);

    public double getPriceOfASurface(Surface surface){
        if(surface == null){ throw new NullPointerException("from Material.getPriceOfASurface()"); }
        return Math.round(getMaterialRequirements(surface) * price * 100) / 100.0;
    }
}
