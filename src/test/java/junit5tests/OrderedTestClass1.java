package junit5tests;

import org.junit.jupiter.api.*;

/////////////////////////////////////////////////////////////////////////////////////////
// @TestInstance(TestInstance.Lifecycle.PER_CLASS                                      //
// this annotation was introduced to reduce the number of objects created when running //
// unit tests.                                                                         //
// add this annotation to your test class will avoid that a new instance of your class //
// is created for every test in the class.                                             //
// this is particularly useful when you have a lot of tests in the same class and the  //
// instantiation of this class is expensive                                            //
/////////////////////////////////////////////////////////////////////////////////////////

@TestMethodOrder(MethodOrderer.DisplayName.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderedTestClass1 {

    ///////////////////////////////////////////////////////////////////////////////////
    // @BeforeAll annotation specifies this method should run before everything else //
    // in the test class                                                             //
    ///////////////////////////////////////////////////////////////////////////////////
    @BeforeAll
    void beforeAll()
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
    @DisplayName("CE-100: TC12 - this method is the second method")
    void secondMethod()
    {
        System.out.println("This is the second test method");
    }

    @Test
    @DisplayName("A Display Name")
    void thirdTest()
    {
        System.out.println("this is the third test message");
    }
}
