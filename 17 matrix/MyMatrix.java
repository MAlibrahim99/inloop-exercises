import java.util.*;
import java.util.stream.Collectors;

public class MyMatrix<T> implements Matrix<T>{

    protected Map<MatrixIndex, T> matrixEntries = new HashMap<>();
    private int maxColumns = 0;
    private int maxRows = 0;


    @Override
    public int getRowCount() {
        int tempRow ;
        int tempCol;

        for(tempRow = maxRows; tempRow >=0; tempRow--){
            for(tempCol = maxColumns; tempCol >= 0; tempCol--){
                if(matrixEntries.get(new MatrixIndex(tempRow, tempCol)) != null)
                    return tempRow + 1;
            }
            tempCol = maxColumns;
        }
        return 0;
        }


    @Override
    public int getColumnCount() {
        int tempRow ;
        int tempCol;

        for(tempCol = maxColumns; tempCol >= 0; tempCol--){
            for(tempRow = maxRows; tempRow >=0; tempRow--){
                if(matrixEntries.get(new MatrixIndex(tempRow, tempCol)) != null)
                    return tempCol + 1;
            }
            tempCol = maxRows;
        }
        return 0;
    }

    @Override
    public int getObjectCount() {
        return (int) matrixEntries
                .keySet()
                .stream()
                .filter(k -> matrixEntries.get(k) != null)
                .count();
    }

    @Override
    public int getDistinctObjectCount() {
        return (int) matrixEntries
                .values()
                .stream()
                .distinct()
                .count();
    }

    @Override
    public Iterator<T> iterator() {
        return new DepthFirstIterator();
    }

    @Override
    public T get(int row, int column) {
        if(row < 0 || column < 0 || row > maxRows || column > maxColumns) throw new  IllegalArgumentException();
        MatrixIndex index = new MatrixIndex(row, column);
        if(matrixEntries.containsKey(index))
            return matrixEntries.get(index);
        return null;
    }

    @Override
    public T put(int row, int column, T value) {
        if (row < 0 || column < 0) throw new IllegalArgumentException();
//        Objects.requireNonNull(value);
        if(row > maxRows) maxRows = row;
        if(column > maxColumns) maxColumns = column;
        MatrixIndex index = new MatrixIndex(row, column);
        if (matrixEntries.containsKey(index) && matrixEntries.get(index) != null) {
            T oldEntry = matrixEntries.get(index);
            matrixEntries.replace(index, value);
            return oldEntry;
        } else {
            matrixEntries.put(index, value);
            return null;
        }
    }

    @Override
    public boolean contains(T value) {
        Objects.requireNonNull(value);
        return matrixEntries.containsValue(value);
    }



    // Matrix iterator class

     class DepthFirstIterator implements Iterator<T> {


         private List<MatrixIndex> temp;
         private Iterator<MatrixIndex> itr;
         public DepthFirstIterator() {
              temp = matrixEntries
                     .keySet()
                     .stream()
                     .filter(entry -> matrixEntries.get(entry) != null)
                     .sorted(MatrixIndex::compareTo)
                     .collect(Collectors.toList());
               itr = temp.iterator();
         }

         @Override
        public boolean hasNext() {
            return itr.hasNext();
        }

        @Override
        public T next() {
            return matrixEntries.get(itr.next());
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}

