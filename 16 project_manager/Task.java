import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Task extends ProjectItem{

    private List<ProjectItem> projectItems;

    public Task(String name, String details, double rate) {
        super(name, details, rate);
        projectItems = new LinkedList<>();
    }

    @Override
    public double getTimeRequired() {
        double tempTime = 0;
        for (ProjectItem pi: projectItems
             ) {
            tempTime += pi.getTimeRequired();
        }
        return tempTime;
    }

    @Override
    public long getMaterialCost() {
        long tempCost = 0;
        for(ProjectItem pi: projectItems){
            tempCost += pi.getMaterialCost();
        }
        return tempCost;
    }

    public void addProjectItem(ProjectItem pi){
        if(pi == null){
            throw new NullPointerException();
        }
        projectItems.add(pi);
    }

    public void removeProjectItem(ProjectItem pi){
        if(pi == null){
            throw new NullPointerException();
        }
        projectItems.remove(pi);
    }

    public List<Deliverable> allDeliverables(){
        List<Deliverable> deliverables = new ArrayList<>();
        List<ProjectItem> queue = new LinkedList<>(projectItems);
        while(!queue.isEmpty()){
            ProjectItem pi = queue.remove(0);
            if(pi instanceof Deliverable){
                deliverables.add((Deliverable) pi);
            }else{
                queue.addAll(((Task) pi).allDeliverables());
            }
        }
        return deliverables;
    }
}
