public class Taxi {

    private Human driver;
    private Human [] passengers;
    private final int capacity = 4;
    private int actualPassengersNumber = 0;
    public Taxi(Human driver) {
        this.driver = driver;
        this.passengers = new Human[capacity];
    }

    public String getDriverName(){
        return driver.getFullName();
    }

    public void add(Human human){
        if(actualPassengersNumber < capacity){
            passengers[actualPassengersNumber] = human;
            System.out.println(human.getFullName() + " gets in.");
            actualPassengersNumber++;
        }else
            System.out.println("We are sorry, " + human.getFullName() + ". The taxi is full.");

    }
    public Human [] allGetOut(){
            Human [] temp = new Human [actualPassengersNumber];
        System.arraycopy(passengers, 0, temp, 0, temp.length);
            actualPassengersNumber = 0 ;
            return temp;
    }
    @Override
    public String toString(){
        switch (actualPassengersNumber){
            case 0:
                return "This is the taxi of " + driver.getFullName() + ". He takes nobody along.";
            case 1:
                return "This is the taxi of " + driver.getFullName() + ". He takes " +passengers[0].getFullName() +
                        " along.";
            case 2:
                return "This is the taxi of " + driver.getFullName() + ". He takes " +passengers[0].getFullName() +" and "+
                        passengers[1].getFullName() + " along.";
            case 3:
                return "This is the taxi of " + driver.getFullName() + ". He takes " +passengers[0].getFullName() +", "+
                        passengers[1].getFullName() + " and " + passengers[2].getFullName() + " along.";
           case 4:
                return "This is the taxi of " + driver.getFullName() + ". He takes " + passengers[0].getFullName() + ", " +
                        passengers[1].getFullName() +
                        ", " + passengers[2].getFullName() + " and "+ passengers[3].getFullName() + " along.";
            default: return null;
        }
    }
}
