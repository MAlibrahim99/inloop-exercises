public class Library {

    private int bookCount = 0;
    private Book[] lib;

    public Library() {

        lib = new Book[10];
        System.out.println("Hello, I am a library, which can store up to 10 books!");
    }

    //add book
    public void add(Book book) {
        if (bookCount <10) {
            lib[bookCount] = book;
            System.out.println("I added the book " + book + "!");
            ++bookCount;
        }
        else
            System.out.println("The library is full!");
    }

    public Book search(String title) {
        int iter = 0;
        while (lib[iter] != null) {
            if (lib[iter].getTitle().equals(title)) {
                System.out.println("The book with the title " + title + " exists in the library!");
                return lib[iter];
            }
            iter++;
        }

        System.out.println("The book with the title " + title + " does not exist in the library!");
        return null;
    }

}
