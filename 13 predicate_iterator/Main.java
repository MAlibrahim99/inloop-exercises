public class Main {

    public static void main(String[] args) {
	// write your code here
        var suffix = "Java";
        var value = "UML and Java";
        Predicate<String> ends = new EndsWith("Java");
        String temp = value.substring(value.length()-suffix.length());
        System.out.println("from main: " + value);
        System.out.println(ends.test(value));
//        System.out.println(temp);

    }
}
