public class EndsWith implements Predicate<String>{

   private String suffix;

    public EndsWith(String suffix) {
        if(suffix == null){
            throw new IllegalArgumentException();
        }
        this.suffix = suffix.trim();
    }

    @Override
    public boolean test(String value) {
        if(value == null ){
            return false;
        }
        var temp = false;
        if(value.length() >= suffix.length()) {
            return suffix.equals(value.trim().substring(value.length() - suffix.length()));
        }
        return false;
        }

}
