package biblioteca.presentation;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class ConsoleUITest {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void shouldBePrintWelcomeMessageWhenStartProgram() {
        ConsoleUI.run();
        assertThat(systemOutRule.getLog(), containsString("Welcome to Biblioteca."));
    }

    @Test
    public void shouldBeShowListOfBooksAfterWelcomeMessage() {
        ConsoleUI.run();
        assertThat(systemOutRule.getLog(), containsString("1. Clean Code (2008) Uncle Bob\n2. The Refactoring (1999) Martin Fowler"));
    }

}
