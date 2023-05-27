public class Paint extends Material{

    private static double limit = 0.02;
    private int numberOfCoats;
    private double squareMetersPerLiter;

    public Paint(String name, double price, int numberOfCoats, double squareMetersPerLiter) {
        super(name, price);
        if(numberOfCoats <= 0 || squareMetersPerLiter <= 0){
            throw new IllegalArgumentException("int numberOfCoats or double squareMetersPerLiter <= 0. correct the arguments");
        }
        this.numberOfCoats = numberOfCoats;
        this.squareMetersPerLiter = squareMetersPerLiter;
    }

    public int getNumberOfCoats() {
        return numberOfCoats;
    }

    public double getSquareMetersPerLiter() {
        return squareMetersPerLiter;
    }

    @Override
    public int getMaterialRequirements(Surface surface) {

        double paintAmount = surface.getArea() * numberOfCoats / squareMetersPerLiter;//should be calculated in liter
        double fractionPaint = paintAmount - Math.floor(paintAmount); // fractionPaint <= 0.99
        int buckets = (int) Math.floor(paintAmount) * 2;
        fractionPaint = Math.round(fractionPaint * 100) / 100.0;

        if (fractionPaint >= 0.52)
            return buckets + 2;
        else if (fractionPaint >= 0.02)
            return buckets + 1;
        else
            return buckets;
    }
}
