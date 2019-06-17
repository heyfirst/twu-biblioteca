package biblioteca.core;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.containsString;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

public class LibraryTest {
    private Library library;

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInMock = TextFromStandardInputStream.emptyStandardInputStream();

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
    public void whenCallShowAllBooksShouldBeShowListOfBooks() {
        this.library.showListOfBooks();

        String actual = log.getLog();
        String expected = "Clean Code (2008) Robert C. Martin\n"
                + "The Refactoring (1999) Martin Fowler\n";

        assertThat(actual, containsString(expected));
    }

    @Test
    public void whenCallShowMenusShouldBePrintOutMenus() {
        this.library.showMenus();

        String actual = log.getLog();
        String expected = "------------------- Menu -------------------";

        assertThat(actual, containsString(expected));
    }

    @Test
    public void whenCallRunMethodAndEnter1InConsoleShouldBeShowListOfBooks() {
        systemInMock.provideLines("1"); // Enter "1" to system.in
        this.library.run();

        String actual = log.getLog();
        String expected = "Clean Code (2008) Robert C. Martin\n"
                + "The Refactoring (1999) Martin Fowler\n";

        assertThat(actual, containsString(expected));
    }
}