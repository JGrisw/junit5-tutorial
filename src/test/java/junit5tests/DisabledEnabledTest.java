package junit5tests;

import junit5tests.listeners.Listener;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(Listener.class)
public class DisabledEnabledTest {

    @Test
    @Disabled(value = "Disabled for demo of @Disabled")
    void firstTest()
    {
        System.out.println("this is the first test method");
    }

    @Test
    @DisabledOnOs(value = OS.WINDOWS)
    void secondTest()
    {
        System.out.println("this is the second test method");
    }

    @Test
    void thirdTest()
    {
        System.out.println("this is the third test method");
    }

    @Test
    void fourthTest()
    {
        System.out.println("this is the fourth test method");
    }

    @Test
    void fifthTest()
    {
        System.out.println("this is the fifth test method");
    }
}
