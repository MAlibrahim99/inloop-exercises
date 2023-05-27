public class Flooring extends Material {

    private static double limit = 0.02;
    private double widthOfFlooring;

    public Flooring(String name, double price, double width ) {

        super(name, price);
        if(width <= 0){
            throw new IllegalArgumentException("Flooring.public Flooring(String name, double price, double width ) "
                    + " has a negative argument 'width'!");
        }
        widthOfFlooring = width;
    }

    public double getWidth() {
        return widthOfFlooring;
    }

    @Override
    public int getMaterialRequirements(Surface surface) {
        double panels = surface.getArea() / this.widthOfFlooring;
        double fractions = panels - Math.floor(panels);
        fractions = Math.round(fractions * 100) / 100.0;
        if(fractions <0.02 ){
            return (int) panels;
        }
        return 1 + (int) panels;
    }
}
