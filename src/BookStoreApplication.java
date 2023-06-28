public class BookStoreApplication {
    public static void main(String[] args) throws Exception {
        Bookstore bookstore = new Bookstore();

        bookstore.addBook(new Book("abc", "someOne", 10));
        bookstore.addBook(new Book("def", "someTwo", 99.9));
        bookstore.addBook(new Book("ghi", "someThree", 15.9));
        bookstore.addBook(new Book("jkl", "someFour", 1));
        bookstore.addBook(new Book("mno", "someFive", 70));
        bookstore.addBook(new Book("pqr", "someSix", 77));


        bookstore.displayBooks();

        System.out.println();

        System.out.println(bookstore.findBook("bbc"));


    }
}