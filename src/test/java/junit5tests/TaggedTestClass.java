package junit5tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TaggedTestClass {

    ///////////////////////////////////////////////////////////////////////////////////
    // @BeforeAll annotation specifies this method should run before everything else //
    // in the test class                                                             //
    ///////////////////////////////////////////////////////////////////////////////////
    @BeforeAll
    static void beforeAll()
    {
        System.out.println(" - - This is the Before All Method");
    }

    //////////////////////////////////////////////////////////////////////////////
    // @BeforeEach annotation specifies this method should run before each test //
    //////////////////////////////////////////////////////////////////////////////
    @BeforeEach
    void beforeEach()
    {
        System.out.println("---- This is the Before Each Method");
    }

    /////////////////////////////////////////////////////////////////////////////////
    // @AfterAll annotation specifies this method should run after everything else //
    // in the test class                                                           //
    /////////////////////////////////////////////////////////////////////////////////
    @AfterAll
    static void afterAll()
    {
        System.out.println(" - - this is the After All Method");
    }

    ////////////////////////////////////////////////////////////////////////////
    // @AfterEach annotation specifies this method should run after each test //
    ////////////////////////////////////////////////////////////////////////////
    @AfterEach
    void afterEach()
    {
        System.out.println("---- This is the After Each Method");
    }

    ////////////////////////////////////////////////////////////////////////////////////
    // When creating tests you need the following                                     //
    // an annotation (below we are using @Test                                        //
    // an access modifier (this can be omitted, but specifically it cannot be private //
    // a return Type - tests cannot return any type of value and must be void         //
    // the name of the method - this should be descriptive of what is being tested    //
    ////////////////////////////////////////////////////////////////////////////////////
    @Test
    @Tag("sanity")
    void firstMethod()
    {
        System.out.println("This is the first test method");
    }

    //////////////////////////////////////////////////////////////////////////////////
    // When using the @Display name annotation you can set a string that will allow //
    // more information about the test above and beyond the method name             //
    // in the below example I am writing the following                              //
    // Story number : Test Case number  - description                               //
    // "CE-100:       TC12 -              this method is the second method"         //
    //////////////////////////////////////////////////////////////////////////////////

    @Test
    @Tag("sanity")
    @Tag("acceptance")
    @DisplayName("CE-100: TC12 - this method is the second method")
    void secondMethod()
    {
        System.out.println("This is the second test method");
    }

    @Test
    @Tag("acceptance")
    void thirdMethod()
    {
        System.out.println("This is the third method.");
    }

    @ParameterizedTest(name = "Run: {index}  - Value: {arguments}")
    @ValueSource(ints = {1,5,6})
    @Tag("acceptance")
    void intValues(int theParam)
    {
        System.out.println("theParam = " + theParam);
    }

}
