package biblioteca.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

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

    @Test
    public void shouldBeReturnSuccessMessageWhenReturnedBook() {
        this.library.checkOut(1);

        String actual = this.library.returnBook(1);
        String expected = "Thank you for returning the book!";

        assertEquals(actual, expected);
    }

    @Test
    public void shouldBeReturnNotAvailableMessageWhenReturnedBook() {
        this.library.checkOut(1);
        this.library.returnBook(1);

        String actual = this.library.returnBook(1);
        String expected = "This is not a valid book to return.";

        assertEquals(actual, expected);
    }

    @Test
    public void shouldBeReturnBookNotAppearMessageWhenReturnedBook() {
        String actual = this.library.returnBook(999);
        String expected = "The book is not appear in the shelf.";

        assertEquals(actual, expected);
    }

    @Test
    public void shouldBeReturnListOfBookWhenCallGetMovies() {
        ArrayList<Movie> actual = this.library.getMovies();
        ArrayList<Movie> expected = new ArrayList<Movie>() {{
            add(new Movie("Avengers: End game", "2019", "Brothers of Russo", 10, true));
            add(new Movie("Need for speed", "2014", "Scott Waugh", 9, true));
        }};

        assertEquals(actual, expected);
    }

    @Test
    public void shouldBeCheckedOutMovieWhenCheckOutMovie() {
        this.library.checkOutMovie(1);

        Movie actual = this.library.getMovie(1);
        Movie expected = new Movie("Need for speed", "2014", "Scott Waugh", 9, false);

        assertEquals(actual, expected);
    }

    @Test
    public void shouldBeLoggedInToLibrary() {
        String username = "XYZ-1234";
        String password = "ThoughtWorks";

        Boolean result = this.library.login(username, password);

        assertTrue(result);
    }
}
