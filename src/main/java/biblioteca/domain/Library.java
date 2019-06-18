package biblioteca.domain;

import java.util.ArrayList;

public class Library {
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
                return "Thank you! Enjoy your book!";
            } else {
                return "The book is not available.";
            }
        } catch (IndexOutOfBoundsException exception) {
            return "The book is not appear in the shelf.";
        }
    }

    public Book getBook(int index) {
        return this.books.get(index);
    }
}
