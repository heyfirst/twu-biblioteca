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
    public void sayWelcome() {
        this.library.sayWelcome();
        assertThat(log.getLog(), containsString("Welcome to Biblioteca. Your one-step-shop for great book titles in Bangalore!"));
    }
}