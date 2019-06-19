package biblioteca.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void shouldBeReturnUserInformation() {
        User user = new User(
                "XYZ-1234",
                "ThoughtWorks",
                "Kanisorn Sutham",
                "kanisorn.sutham@thoughtWorks.com",
                "+66 (0) 88 252 9594"
        );

        String actual = user.toString();
        String expected = "[XYZ-1234] Kanisorn Sutham | kanisorn.sutham@thoughtWorks.com | +66 (0) 88 252 9594";

        assertEquals(actual, expected);
    }
}