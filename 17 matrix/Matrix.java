import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public interface Matrix<T> {
    int getRowCount();
    int getColumnCount();
    int getObjectCount();
    int getDistinctObjectCount();
    Iterator<T> iterator();
    T get(int row, int column);
    T put(int row, int column, T value);
    boolean contains(T value);
}
