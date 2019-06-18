package biblioteca.presentation;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConsoleUITest {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    @Rule
    public final TextFromStandardInputStream systemInMock  = TextFromStandardInputStream.emptyStandardInputStream();
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    ConsoleUI consoleUI;

    @Before
    public void setUp() {
        consoleUI = new ConsoleUI();
    }

    @Test
    public void shouldBePrintWelcomeMessageWhenCallWelcomeMessage() {
        this.consoleUI.welcomeMessage();
        assertThat(systemOutRule.getLog(), containsString("Welcome to Biblioteca."));
    }

    @Test
    public void shouldBeShowListOfMenuWhenCallMenuOptions() {
        this.consoleUI.menuOptions();
        assertThat(systemOutRule.getLog(), containsString("------- Menus -------"));
    }

    @Test
    public void shouldBeShowListOfBooksWhenSelectOption1() {
        systemInMock.provideLines("1");
        this.consoleUI.selectMenuOption();
        assertThat(systemOutRule.getLog(), containsString("1. Clean Code (2008) Uncle Bob [AVAILABLE]\n2. The Refactoring (1999) Martin Fowler [AVAILABLE]"));
    }

    @Test
    public void shouldBeRaiseInvalidOptionWhenSelectOptionString() {
        systemInMock.provideLines("string");
        this.consoleUI.selectMenuOption();
        assertThat(systemOutRule.getLog(), containsString("Please select a valid option!"));
    }

    @Test
    public void shouldBeExitProgramWhenSelectOptionExit() {
        exit.expectSystemExit();
        systemInMock.provideLines("9");
        this.consoleUI.run();
    }
}
