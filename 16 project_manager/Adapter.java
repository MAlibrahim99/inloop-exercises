import java.util.ArrayList;
import java.util.List;

public class Adapter implements IProject{

    private Project oldSystem;

    public Adapter(String name, String description, double rate) {
        this.oldSystem = new Project(name, description, rate);
    }

    @Override
    public void setTask(Task newTask) {
        if(newTask == null){
            throw new NullPointerException();
        }
        oldSystem.setTask(newTask);
    }

    @Override
    public double getDuration() {
        return oldSystem.getDuration();
    }

    @Override
    public long getTotalCost() {
        return oldSystem.getTotalCost();
    }

    @Override
    public List<Deliverable> getDeliverables() {

        List<Deliverable> allDeliverables = new ArrayList<>();
        for (List<Deliverable> delev : oldSystem.allDeliverables().values()){
            allDeliverables.addAll(delev);
        }
        return allDeliverables;
    }
}
