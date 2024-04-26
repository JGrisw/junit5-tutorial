package junit5tests;

import junit5tests.listeners.Listener;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(Listener.class)
public class AssertionsTestClass {

    @Test
    void assertEqualsTest()
    {
        assertEquals("firstString", "secondString", "The String values were not equal" );
    }

    @Test
    void assertEqualsListTest()
    {
        List<String> expectedValues = Arrays.asList("firstString", "secondString", "thirdString");

        List<String> actualValues = Arrays.asList("firstString", "secondString", "thirdString");

        assertEquals(expectedValues,actualValues);
    }

    @Test
    void assertArraysEqualsTest()
    {
        int[] expectedValues = {1,2,3};
        int[] actualValues = {1,2,3};

        assertArrayEquals(expectedValues,actualValues);
    }

    @Test
    void assertTrueTest()
    {
        assertFalse(false);
        assertTrue(false, "This boolean condition did not evaluate to true");
    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    // Begin - Hamcrest Tests                                                                   //
    // Hamcrest is an external additional library with additional assertions and tests that you //
    // can utilize in your tests.                                                               //
    // first must be added to the dependencies in the pom.xml file                              //
    //////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    void assertForMapTest()
    {
        Map<String, Integer> theMap = new HashMap<>();

        theMap.put("FirstKey", 1);
        theMap.put("SecondKey", 2);
        theMap.put("thirdKey", 3);

        assertThat(theMap, Matchers.hasValue(2));
        assertThat(theMap, Matchers.hasKey("SecondKey"));
    }

    @Test
    void assertForList()
    {
        List<String> theList = Arrays.asList("FirstString", "SecondString", "ThirdString");

        assertThat(theList, Matchers.hasItem("FirstString"));
    }

    @Test
    void assertForAnyOf()
    {
        List<String> theList = Arrays.asList("FirstString", "SecondString", "ThirdString");

        assertThat(theList, Matchers.anyOf(Matchers.hasItem("FirstString"), Matchers.hasItem("noString")));
    }

    @Test
    void assertForContainsAnyOrder()
    {
        List<String> theList = Arrays.asList("FirstString", "SecondString", "ThirdString");

        assertThat(theList, Matchers.containsInAnyOrder( "SecondString", "ThirdString","FirstString"));
    }
}
