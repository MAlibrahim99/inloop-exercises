public class Bottle<T extends Drink> {
    private T content;

    public Bottle() {
    }

    public void fill(T drink){
        if(drink != null && isEmpty())
            this.content = drink;
        else
        throw new IllegalStateException();
    }

    public boolean isEmpty(){
        return (content == null);
    }

    public T empty(){
        if(content != null) {
            T t = content;
            content = null;
            return t;
        }
            throw new IllegalStateException("Trying to empty an empty bottle");
    }
}
