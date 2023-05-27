public class StartsWith implements Predicate<String>{

    private String prefix;

    public StartsWith(String prefix) {
        if(prefix == null){
            throw new IllegalArgumentException();
        }
        this.prefix = prefix;
    }

    @Override
    public boolean test(String value) {
        if(value == null || prefix.length() > value.length()){
            return false;
        }

        String temp = value.substring(0, prefix.length());
        return temp.equals(prefix);
    }
}
