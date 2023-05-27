package collections1;
import java.util.*;
public class Book implements Comparable<Book>{
    private String isbn;
    private String author = "";
    private String title = "";

    public Book(String isbn, String author, String title) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
    }
    public Book(String isbn){
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
    public String toString(){
        return this.title;
}
@Override
    public int compareTo(Book BookToCompare){
        return this.isbn.compareToIgnoreCase(BookToCompare.getIsbn());
}
}
