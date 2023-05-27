import com.sun.source.tree.Tree;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class EventCatalogImpl extends TreeMap<Event, Set<Time>> implements EventCatalog{

    Map<Event, Set<Time>> storage = new TreeMap<>();

    public EventCatalogImpl() {
    }

    @Override
    public boolean addCatalogEntry(Event e, Set<Time> tSet) {
        if(e == null || tSet == null) throw new NullPointerException();
        Set<Time> temp = new HashSet<>(tSet);
        temp.removeIf(t -> !isValidTime(t));
        if(storage.containsKey(e))
            return false;
        storage.put(e,temp);
        return true;
    }

    @Override
    public boolean addTimeToEvent(Event e, Time t) {
        if(e == null || t == null) throw new NullPointerException();
        if(!isValidTime(t) || !storage.containsKey(e))
            return false;

        for (Event event: storage.keySet()
             ) {
            if(event.compareTo(e) == 0 && !storage.get(event).contains(t)) {
                storage.get(event).add(t);
                return true;
            }

        }
        return false;
    }

    @Override
    public Set<Event> getAllEvents() {
        return storage.keySet();
    }

    @Override
    public Set<Time> getTimesOfEvent(Event e) {
        if(e == null) throw new NullPointerException();
        if(!storage.containsKey(e) /*|| storage.get(e).size() == 0*/)
            return null;
        return storage.get(e);// it maybe needs to add one more condition to work properly
        //if(storage.get(e) )
    }

    @Override
    public Map<Event, Set<Time>> filterByEventCategory(EventCategory category) {
        if(category == null ) throw new NullPointerException();
        Map<Event, Set<Time>> temp = new TreeMap<>();
        for(Event event : storage.keySet()){
            if(event.getCategory().equals(category)){
                temp.put(event, storage.get(event));
            }
        }
        return temp;
    }

    @Override
    public Set<Time> deleteEvent(Event e) {
        if(e == null) throw new NullPointerException();
//        if(storage.containsKey(e) && storage.get(e).size() != 0) {
//            Set<Time> times = new HashSet<>(storage.get(e));
            return storage.remove(e);
//            return times;

//        return null;
    }

    @Override
    public boolean deleteTime(Event e, Time t) {
        if(e == null || t == null) throw new NullPointerException();
        if(storage.containsKey(e) && storage.get(e).contains(t)){
            storage.get(e).remove(t);
            return true;
        }
        return false;
    }

    private boolean isValidTime(Time time){
        return (time.getMinute() >= 0 || time.getMinute() <= 59) && (time.getHour() >= 0 || time.getHour() < 24);
    }
}
