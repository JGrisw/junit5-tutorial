package junit5tests;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

public class MiscTest {

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void timeout() throws InterruptedException {
        System.out.println("This is the test with the timeout");
        //Thread.sleep(6000);
    }

    @Test
    @Timeout(90)
    @DisplayName("this is the nice method")
    @Tag("theTag")
    void annotatedMethod1()
    {
        System.out.println("this is the annotated method");
    }

    @MyAnnotation
    void annotatedMethod2()
    {
        System.out.println("this is the custom annotated method");
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class NestedTest
    {
        @BeforeAll
        void beforeAll()
        {
            System.out.println("before all nested test");
        }

        @Test
        void nestedTestMethod()
        {
            System.out.println("Nested Test");
        }
    }
}
