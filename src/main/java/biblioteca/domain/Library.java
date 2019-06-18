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

    public void checkOut(int index) {
        this.books.get(index).setAvailable(false);
    }

    public Book getBook(int index) {
        return this.books.get(index);
    }
}
