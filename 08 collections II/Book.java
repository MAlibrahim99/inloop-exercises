package collections2;

public class Book implements Comparable<Book> {
    private String isbn;
    private String author = "";
    private String title = "";

    public Book(String isbn, String author, String title) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
    }

    public Book(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title + " by " +
                author +
                " (ISBN " + isbn + ")";
    }

    @Override
    public int compareTo(Book BookToCompare) {
        return this.isbn.compareToIgnoreCase(BookToCompare.getIsbn());
    }

    @Override
    public int hashCode() {
//        return Integer.parseInt(isbn);
        return isbn.hashCode();
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Book)) {
            return false;
        }
        return ((Book) o).getIsbn().equals(this.getIsbn());
    }
}



