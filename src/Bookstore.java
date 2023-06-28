import java.util.ArrayList;
import java.util.List;

public class Bookstore {
    List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public Book findBook(String title) throws BookNotFoundException {
        try {
            for (int i = 0; i < books.size(); i++) {
                if (title.equalsIgnoreCase(books.get(i).getTitle())) {
                    return books.get(i);
                } else {
                    throw new BookNotFoundException();
                }
            }
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void displayBooks() {
        for (var actual : books) {
            System.out.println(actual);
        }
    }
}
