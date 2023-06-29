import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bookstore {
    private List<Book> books = new ArrayList<>();
    private Map<Book, Integer> bookz = new HashMap<>();


    public void addBook(Book book) {
        if (bookz.containsKey(book)) {
            this.bookz.replace(book, (bookz.get(book) + 1));
        } else {
            this.bookz.put(book, 1);
        }
    }

    public void addBook(Book book, int quantity) {
        if (bookz.containsKey(book)) {
            this.bookz.replace(book, (bookz.get(book) + quantity));
        }
        bookz.put(book, quantity);
    }

    public Book findBook(String title) throws BookNotFoundException {
        for (Book book : bookz.keySet()) {
            if (title.equalsIgnoreCase(book.getTitle())) {
                return book;
            }
        }
        throw new BookNotFoundException();
    }

    public void displayBooks() {
        System.out.println("Books available: ");
        for (Map.Entry<Book, Integer> book : bookz.entrySet()) {
            System.out.println(book.getKey() + ": " + book.getValue() + " db.");
        }

    }

    public void sellBook(String title, int quantity) throws BookNotFoundException, InsufficientStockException {
        Book book = findBook(title);
        if (!bookz.containsKey(book)) {
            throw new InsufficientStockException("Book not found");
        } else if (bookz.get(book) < quantity) {
            throw new InsufficientStockException("Insufficient stock");
        }

        bookz.replace(book, bookz.get(book) - quantity);
    }
}
