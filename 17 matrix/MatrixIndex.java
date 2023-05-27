import java.util.Comparator;
import java.util.Objects;

public class MatrixIndex implements Comparable<MatrixIndex> {
    private int row;
    private int column;

    public MatrixIndex(int row, int column){
        if(row < 0 || column < 0) throw new IllegalArgumentException();
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }


    @Override
    public int compareTo(MatrixIndex o) {
        Objects.requireNonNull(o);
                if(this.getColumn() == o.getColumn()){
                    if(this.getRow() < o.getRow())
                        return -1;
                    else
                        return 1;
                }else{
                    if(this.getColumn() < o.getColumn())
                        return -1;
                    else return 1;
                }

//        return 0;
    }

    @Override
    public boolean equals(Object o){
        Objects.requireNonNull(o);
        MatrixIndex matrixIndex;
        try{
            matrixIndex = (MatrixIndex) o;
            return this.row == matrixIndex.getRow() && this.column == matrixIndex.getColumn();

        }catch (ClassCastException classCastException){
            System.err.println("you tried to assign non MatrixIndex object to matrixIndex target");
        }
        return false;
    }

    @Override
    public int hashCode(){
        return -1;
    }
}
