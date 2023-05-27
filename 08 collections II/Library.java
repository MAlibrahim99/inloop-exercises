package collections2;

import java.util.*;

//use arraylist to store books objects
public class Library{
    private Set<Book> stock;

    public Library() {
        stock = new TreeSet<Book>();
    }



    public boolean insertBook(Book newBook) {
     return stock.add(newBook);
    }

    public void setStock(Set<Book> stock) {
        this.stock = stock;
    }

    public Set<Book> getStock() {
        return stock;
    }

    public Book searchForIsbn(String isbn) {
        Book temp = new Book(isbn);
        Iterator<Book> itr = stock.iterator();
        while (itr.hasNext()){
            Book next = itr.next();
            if(next.getIsbn().equals(isbn))
                return next;
        }return null;
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
