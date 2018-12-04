package com.ap.questionset_java.QuestionTwo;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
@SpringBootTest
public class QuestionTwoTestFixture {


    @Test
    @Parameters(method = "parametersToTestAdd")
    public void IsPalindromeTest(String input, Boolean expected) {
        assertEquals(expected, Palindrome.Check(input));
    }

    private Object[] parametersToTestAdd() {
        return new Object[]{
                new Object[]{"taco cat", true},
                new Object[]{"some men interpret nine memos", true},
                new Object[]{"never odd or even", true},
                new Object[]{"This is not a palindrom", false},
                new Object[]{"1 test for numerics", false},
                new Object[]{"289982", true},
                new Object[]{"1234321", true},
        };
    }
}
