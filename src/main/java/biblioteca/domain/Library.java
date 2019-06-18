package biblioteca.domain;

import java.util.ArrayList;

public class Library {
    private static final String CHECKOUT_SUCCESS_MESSAGE = "Thank you! Enjoy your book!";
    private static final String CHECKOUT_NOT_AVAILABLE_MESSAGE = "The book is not available.";

    private static final String RETURN_SUCCESS_MESSAGE = "Thank you for returning the book!";
    private static final String RETURN_NOT_AVAILABLE_MESSAGE = "This is not a valid book to return.";

    private static final String BOOK_NOT_APPEAR_MESSAGE = "The book is not appear in the shelf.";

    ArrayList<Book> books = new ArrayList<Book>() {{
        add(new Book("Clean Code", "2008", "Uncle Bob"));
        add(new Book("The Refactoring", "1999", "Martin Fowler"));
    }};

    public ArrayList<Book> getBooks() {
        return this.books;
    }

    public String checkOut(int index) {
        try {
            if (this.books.get(index).isAvailable()) {
                this.books.get(index).setAvailable(false);
                return CHECKOUT_SUCCESS_MESSAGE;
            } else {
                return CHECKOUT_NOT_AVAILABLE_MESSAGE;
            }
        } catch (IndexOutOfBoundsException exception) {
            return BOOK_NOT_APPEAR_MESSAGE;
        }
    }

    public Book getBook(int index) {
        return this.books.get(index);
    }

    public String returnBook(int index) {
        try {
            if (!this.books.get(index).isAvailable()) {
                this.books.get(index).setAvailable(true);
                return RETURN_SUCCESS_MESSAGE;
            } else {
                return RETURN_NOT_AVAILABLE_MESSAGE;
            }
        } catch (IndexOutOfBoundsException exception) {
            return BOOK_NOT_APPEAR_MESSAGE;
        }

    }
}
