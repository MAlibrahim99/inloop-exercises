import java.util.Map;
import java.util.TreeMap;

public class Surface extends RenovationObject{

    private double length;
    private double width;
    private Material selectedMaterial;

    public Surface(double length, double width) {
        if(length <= 0 || width <= 0){
            throw new IllegalArgumentException("width or length cannot be zero or negative !");
        }
        this.length = length;
        this.width = width;
    }

    public void setMaterial(Material material){
        if(material == null){
            throw new NullPointerException("material cannot be set to null");
        }else{
            this.selectedMaterial = material;
        }
    }

    public double getArea(){
        return width * length;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public double getPrice() {
        return selectedMaterial.getPriceOfASurface(this);
    }

//    @Override
//    public Map<String, Integer> addMaterialRequirements(Map<String, Integer> mr) {
//        if(mr == null || mr.containsValue(null) || selectedMaterial == null){
//            throw new NullPointerException("addMaterialRequirements() got a null argument");
//        }
//        Map<String, Integer> temp = new TreeMap<>(mr);
//        String materialName = selectedMaterial.getName();
//
//        if(temp.containsKey(materialName)){
//            Integer updatedAmount = temp.get(materialName) +  selectedMaterial.getMaterialRequirements(this);
//            temp.put(materialName, (Integer) updatedAmount);
//            System.out.println(materialName + ": " + updatedAmount);
//        }else {
//            temp.put(materialName, (Integer) selectedMaterial.getMaterialRequirements(this));
//        }
//        return temp;
//    }
    @Override
    public Map<String, Integer> addMaterialRequirements(Map<String, Integer> materials) {
        if (materials == null) {
            throw new NullPointerException();
        }

        for (Map.Entry<String, Integer> entry : materials.entrySet()) {
            if (entry.getKey() == null || entry.getValue() == null) {
                throw new NullPointerException();
            }
        }
        if (selectedMaterial == null) {
            throw new NullPointerException();
        }
        Map<String, Integer> temp = new TreeMap<>(materials);
        if(temp.containsKey(selectedMaterial.getName())){
            temp.put(selectedMaterial.getName(), temp.get(selectedMaterial.getName())+ selectedMaterial.getMaterialRequirements(this));
        }else{
            temp.put(selectedMaterial.getName(), selectedMaterial.getMaterialRequirements(this));
        }


    return temp;
}
}
