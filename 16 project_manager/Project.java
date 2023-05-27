import java.time.LocalDate;
import java.util.*;

public class Project {
    private String name;
    private String description;
    private Task mainTask;
    private double rate;

    /**
     * @param name (String) the name of project
     * @param description (String) about the project
     * @param rate (double) */
    public Project(String name, String description, double rate) {
        if(name == null || description == null){
            throw new NullPointerException();
        }
        if(name.equals("") || rate <= 0){
            throw new IllegalArgumentException();
        }
        this.mainTask = new Task(name, description, rate);
        this.name = name;
        this.rate = rate;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setTask(Task newTask) {
        if(newTask == null){
            throw new NullPointerException();
        }
        mainTask = newTask;
    }

    public long getTotalCost(){
        long costs = 0;
        for(Deliverable del : mainTask.allDeliverables()){
            costs += del.getCostEstimate();
        }
        return costs;
//        return  mainTask.getMaterialCost();
    }

    public double getDuration(){
        return mainTask.getTimeRequired();
    }

    public Map<LocalDate, List<Deliverable>> allDeliverables(){
        Map<LocalDate, List<Deliverable>> deliverableMap = new HashMap<>();
        List<Deliverable> deliverables = new ArrayList<>(mainTask.allDeliverables());
        while(!deliverables.isEmpty()){
            Deliverable dev = deliverables.remove(0);
            if(deliverableMap.containsKey(dev.getDate())){
                List<Deliverable> values = deliverableMap.get(dev.getDate());
                values.add(dev);
                deliverableMap.put(dev.getDate(), values);
            }else{
                List<Deliverable> valuse1 = new ArrayList<>();
                valuse1.add(dev);
                deliverableMap.put(dev.getDate(), valuse1);
            }
        }
        return deliverableMap;
    }

}
