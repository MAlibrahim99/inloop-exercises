import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class PredicateIterator <T> implements Iterator<T>{

    private Iterator<T> iter;
    private Predicate<T> predicate;
    private Iterator<T> listIter;
    private List<T> filteredValues;
    public PredicateIterator(Iterator<T> iter, Predicate<T> predicate) {
        if(iter == null || predicate == null){
            throw new NullPointerException();
        }
        this.iter = iter;
        this.predicate = predicate;
        filteredValues = new LinkedList<>();
        setUp();
        listIter = filteredValues.listIterator();
        }


    public boolean hasNext(){
        return listIter.hasNext();
    }

    public T next(){
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        return listIter.next();
    }

    private void setUp(){
        while(iter.hasNext()){
            T temp = iter.next();
            if(predicate.test(temp)) {
                filteredValues.add(temp);
            }
        }
    }
  }
