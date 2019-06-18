package biblioteca.domain;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class LibraryTest {
    private Library library;

    @Before
    public void setUp() {
        this.library = new Library();
    }

    @Test
    public void shouldBeReturnListOfBookWhenCallGetBooksMethod() {
        ArrayList<Book> actual = this.library.getBooks();
        ArrayList<Book> expected = new ArrayList<Book>() {{
            add(new Book("Clean Code", "2008", "Uncle Bob"));
            add(new Book("The Refactoring", "1999", "Martin Fowler"));
        }};

        assertEquals(actual, expected);
    }

    @Test
    public void shouldBeCheckedOutBookWhenCallCheckoutByIndex() {
        this.library.checkOut(1);

        Book actual = this.library.getBook(1);
        Book expected = new Book("The Refactoring", "1999", "Martin Fowler", false);

        assertEquals(actual, expected);
    }

    @Test
    public void shouldBeReturnSuccessMessageWhenCheckedOutBook() {

        String actual = this.library.checkOut(1);
        String expected = "Thank you! Enjoy your book!";

        assertEquals(actual, expected);
    }

    @Test
    public void shouldBeReturnNotAvailableMessageWhenCheckedOutBook() {
        this.library.checkOut(1);

        String actual = this.library.checkOut(1);
        String expected = "The book is not available.";

        assertEquals(actual, expected);
    }

    @Test
    public void shouldBeReturnBookNotAppearMessageWhenCheckedOutBook() {
        String actual = this.library.checkOut(999);
        String expected = "The book is not appear in the shelf.";

        assertEquals(actual, expected);
    }

    @Test
    public void shouldBeReturnBookToLibraryWhenCallReturnBook() {
        this.library.checkOut(1);

        this.library.returnBook(1);

        Book actual = this.library.getBook(1);
        Book expected = new Book("The Refactoring", "1999", "Martin Fowler", true);

        assertEquals(actual, expected);
    }
}
