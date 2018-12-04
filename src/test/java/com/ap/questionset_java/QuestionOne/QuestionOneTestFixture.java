package com.ap.questionset_java.QuestionOne;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionOneTestFixture {

    private ReverseAndInterWeave reverseAndInterWeave;

    @Before
    public  void Before() {
        reverseAndInterWeave  = new ReverseAndInterWeave();
    }

    @Test
    public void Given_AValidString_AlwaysReturns_TheOriginalInterwovenWithReverse() {

        // Arrange
        final String input = "ab12";
        final String expected = "a2b11b2a";

        // Act
        String actual = reverseAndInterWeave.Execute(input);

        // Assert
        assertEquals("strings should be equal",expected, actual);
    }

    @Test
    public void Given_AnotherValidstring_Always_Returns_TheOriginalInterwovenWithReverse()
    {
        // Arrange
        String input = "5t>mKar/Dm!fj/d7";
        final String expected = "57td>/mjKfa!rm/DD/mr!afKjm/>dt75";

        // Act
        String actual = reverseAndInterWeave.Execute(input);

        // Assert
        assertEquals("strings should be equal",expected, actual);

    }
}
