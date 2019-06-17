package biblioteca.core;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.containsString;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

public class LibraryTest {
    private Library library;

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Before
    public void setUp() {
        this.library = new Library();
    }

    @Test
    public void whenCallSayWelcomeMethodShouldBePrintOutWelcomeMessage() {
        this.library.sayWelcome();

        String actual = log.getLog();
        String expected = "Welcome to Biblioteca. Your one-step-shop for great book titles in Bangalore!";

        assertThat(actual, containsString(expected));
    }

    @Test
    public void whenCallShowAllBooksShouldBePrintOutListOfBooks() {
        this.library.showListOfBooks();

        String actual = log.getLog();
        String expected = "Clean Code (2008) Robert C. Martin\n"
                + "The Refactoring (1999) Martin Fowler\n";

        assertThat(actual, containsString(expected));
    }
}