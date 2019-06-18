package biblioteca.presentation;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConsoleUITest {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    @Rule
    public final TextFromStandardInputStream systemInMock  = TextFromStandardInputStream.emptyStandardInputStream();

    @Test
    public void shouldBePrintWelcomeMessageWhenStartProgram() {
        systemInMock.provideLines("1");
        ConsoleUI.run();
        assertThat(systemOutRule.getLog(), containsString("Welcome to Biblioteca."));
    }

    @Test
    public void shouldBeShowListOfMenuWhenStartProgram() {
        systemInMock.provideLines("1");
        ConsoleUI.run();
        assertThat(systemOutRule.getLog(), containsString("------- Menus -------"));
    }

    @Test
    public void shouldBeShowListOfBooksWhenSelectOption1() {
        systemInMock.provideLines("1");
        ConsoleUI.run();
        assertThat(systemOutRule.getLog(), containsString("1. Clean Code (2008) Uncle Bob\n2. The Refactoring (1999) Martin Fowler"));
    }

    @Test
    public void shouldBeRaiseInvalidOptionWhenSelectOptionString() {
        systemInMock.provideLines("string");
        ConsoleUI.run();
        assertThat(systemOutRule.getLog(), containsString("Please select a valid option!"));
    }

}
