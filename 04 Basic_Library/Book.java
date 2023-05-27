public class Book {

    private String title;

    public Book(String title) {
        this.title = title;
        confirmInstantiation();
    }

    private void confirmInstantiation() {
        System.out.println("Book " + title + " created.");
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}
