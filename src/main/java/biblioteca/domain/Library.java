package biblioteca.domain;

import java.util.ArrayList;

public class Library {
    public ArrayList<Book> getBooks() {
        return new ArrayList<Book>() {{
            add(new Book("Clean Code", "2008", "Uncle Bob"));
            add(new Book("The Refactoring", "1999", "Martin Fowler"));
        }};
    }
}
