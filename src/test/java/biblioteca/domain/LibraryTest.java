package biblioteca.domain;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class LibraryTest {
    @Test
    public void shouldBeReturnListOfBookWhenCallGetBooksMethod() {
        Library library = new Library();

        ArrayList<Book> actual = library.getBooks();
        ArrayList<Book> expected = new ArrayList<Book>() {{
            add(new Book("Clean Code", "2008", "Uncle Bob"));
            add(new Book("The Refactoring", "1999", "Martin Fowler"));
        }};

        assertEquals(actual, expected);
    }
}
