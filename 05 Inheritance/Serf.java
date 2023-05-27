public class Serf extends Peasant {

    @Override
    public int tax(){
        if(taxableIncome()<=0)
            return 0;
        if(taxableIncome()<10)
            return 1;
        return taxableIncome()/10;
    }

    @Override
    public int taxableIncome(){
        if(getIncome()-12 <0)
            return 0;
        return (getIncome() -12);
    }
}