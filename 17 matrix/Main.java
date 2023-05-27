import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MatrixIndex matr00 = new MatrixIndex(0,0);
        MatrixIndex matr10 = new MatrixIndex(1,0);
        MatrixIndex matr20 = new MatrixIndex(2,0);
        MatrixIndex matr01 = new MatrixIndex(0,1);
        MatrixIndex matr11 = new MatrixIndex(1,1);
        MatrixIndex matr21 = new MatrixIndex(2,1);
        MatrixIndex matr02 = new MatrixIndex(0,2);
        MatrixIndex matr12 = new MatrixIndex(1,2);
        MatrixIndex matr22 = new MatrixIndex(2,2);

        Matrix<String> matrix = new MyMatrix<>();

        matrix.put(0,0,"c");
        matrix.put(1,0,"a");
        matrix.put(2,0,"b");
        matrix.put(0,1,"w");
        matrix.put(1,1,"f");
        matrix.put(2,1,"i");
        matrix.put(0,2,"d");
        matrix.put(1,2,"e");
        matrix.put(2,2,"o");

//        System.out.println(matrix.contains("c"));
//        Iterator<String> iter = matrix.iterator();
//        while(iter.hasNext()){
//            String temp = iter.next();
//            System.out.println(temp);
//        }

    }
}
