import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class RenovationObject {

    public abstract double getPrice();
    public abstract Map<String, Integer> addMaterialRequirements(Map<String, Integer> mr);
}
