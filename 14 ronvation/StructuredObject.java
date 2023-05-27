import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class StructuredObject extends RenovationObject{

    private Set<RenovationObject> parts = new HashSet<>();

    public void add(RenovationObject ro){
        if(ro == null){
            throw new NullPointerException();
        }
        this.parts.add(ro);
    }

    @Override
    public double getPrice(){
        double price1 = 0;
        for (RenovationObject part: parts
             ) {
            price1 += part.getPrice();
        }
        return price1;
    }

        @Override
    public Map<String, Integer> addMaterialRequirements(Map<String, Integer> mr) {
        if(mr == null  || mr.containsValue(null)){
            throw new NullPointerException("addMaterialRequirements() got a null argument");
        }
        Map<String, Integer> temp = new TreeMap<>(mr);
            for (RenovationObject ro: parts) {
                temp = ro.addMaterialRequirements(temp);
            }
        return temp;
    }
}
