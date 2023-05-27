package collections1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

//use arraylist to store books objects
public class Library {
    private List<Book> stock;

    public Library() {
        stock = new ArrayList<>();
    }

    public boolean insertBook(Book newBook) {
        int i = Collections.binarySearch(stock, newBook);
        if (i <= 0) {
            stock.add(newBook);
            System.out.println("The Book " + newBook.getTitle() + " is added to lib.");
            Collections.sort(stock, Book::compareTo);
            return true;
        }
        return false;
    }

    public Book searchForIsbn(String isbn) {
        Book temp = new Book(isbn);
        Collections.sort(stock, Book::compareTo);
        int result = Collections.binarySearch(stock, temp);
        if (result >= 0)
            return stock.get(result);
        return null;
    }

    public Collection<Book> searchForAuthor(String author){
        Book book = new Book("", author, "");
        List<Book> copyOfLib = new ArrayList<>(stock);
        Comparator<Book> byAuthor = Comparator.comparing(Book::getAuthor);
        copyOfLib.sort(byAuthor);
        List<Book> booksOfAuthor = new ArrayList<>();
        for (Book o:copyOfLib) {
            if(book.getAuthor().equals(o.getAuthor())){
                booksOfAuthor.add(o);
            }
        }
        return booksOfAuthor;
    }
    public void prints(){
        for (Book o:stock) {
            System.out.println("-" + o.getIsbn());

        }
    }

}
