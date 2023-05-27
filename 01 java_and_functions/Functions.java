public class Functions {

    public static void main(String[] args) {

            }
    public static int factorial(int n){
        if(n == 0 || n == 1) return 1;
        else if(n<0) return -1;
        else{
            int temp = n;
            for(int i=1;i<n;i++){
                temp *= i;
            }
            return temp;
        }
    }
}