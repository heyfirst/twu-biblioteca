package biblioteca.domain;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

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

    @Test
    public void shouldBeCheckedOutBookWhenCallCheckoutByIndex() {
        Library library = new Library();
        library.checkOut(1);

        Book actual = library.getBook(1);
        Book expected = new Book("The Refactoring", "1999", "Martin Fowler", false);

        assertEquals(actual, expected);
    }
}
