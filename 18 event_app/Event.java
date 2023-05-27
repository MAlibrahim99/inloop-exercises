import java.util.Comparator;

public class Event implements Comparable<Event> {


    private String title;
    private EventCategory category;

    public Event(String title, EventCategory category) {
        if (title == null || category == null) throw new NullPointerException();
        if(title.equals("")) throw new IllegalArgumentException();
//        for (EventCategory category1: EventCategory.values()){
//            if(category.equals(category1))
//                break;
//
//        }
        this.title = title;
        this.category = category;
    }

    @Override
    public int compareTo(Event event) {
        if (title.equals(event.getTitle())) {
            return category.compareTo(event.category);
        }
        return title.compareTo(event.getTitle());

    }

    public String getTitle() {
        return title;
    }

    public EventCategory getCategory() {
        return category;
    }

    //    @Override
//    public int compareTo(Event event, Event event1) {
//            return ;
//    }
}
