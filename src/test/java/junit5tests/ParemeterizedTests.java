package junit5tests;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParemeterizedTests {

    ///////////////////////////////////////////////////////////////////////////////////
    // @parameterizedTests is a feature that enables a user to execute a single test //
    // method multiple times with different parameters.                              //
    // @ValueSource  used to pass an array of literal values to the test method      //
    ///////////////////////////////////////////////////////////////////////////////////
    @ParameterizedTest(name = "Run: {index}  - Value: {arguments}")
    @ValueSource(ints = {1,5,6})
    void intValues(int theParam)
    {
        System.out.println("theParam = " + theParam);
    }

    //////////////////////////////////////////////////////////////////////////////////
    // In order to pass both null and empty values when testing strings  we can use //
    // the @NullAndEmptySource annotation which combines @NullSource                //
    // and @EmptySource                                                             //
    //////////////////////////////////////////////////////////////////////////////////
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = { "FirstString", "SecondString"})
    void stringValues(String theParam)
    {
        System.out.println("theParam = " + theParam);
    }

    //////////////////////////////////////////////////////////////////////////////
    // @CsvSource pass several parameters which reads as comma separated values //
    //////////////////////////////////////////////////////////////////////////////
    @ParameterizedTest
    @CsvSource(value = {"Steve, Rogers", "Tony,Stank", "Peter, Porker"})
    void csvSource_StringString(String param1, String param2)
    {
        System.out.println("Param1 = " + param1 + ", Param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"Steve, 32, true", "Captain, 21, false", "Bucky, 3, true"})
    void csvSource_StringIntBoolean(String param1, int param2, boolean param3)
    {
        System.out.println("Param1 = " + param1 + ", Param2 = " + param2 + ", Param3 = " + param3);
    }

    @ParameterizedTest
    @CsvSource(value = {"captain america, 'Steve, Rogers'", "Vinter Solder," + "'bucky,barnes'"})
    void csvSource_StringWithComa(String param1, String param2)
    {
        System.out.println("Param1 = " + param1 + ", Param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"Steve?Rogers", "bucky?Barnes"}, delimiter = '?')
        void csvSource_StringWithDifferentDelimiter(String param1, String param2)
        {
            System.out.println("Param1 = " + param1 + ", Param2 = " + param2);
        }


    @ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/params/shoppinglist.csv", "src/test/resources/params/shoppinglist2.csv"}, numLinesToSkip = 1)
    void csvFileSource_StringDoubleIntStringString(String name, double price, int quantity, String uom, String provider)
    {
        System.out.println("Name = " + name + ", Price = " + price + ", Qty = " + quantity + ", UOM = " + uom + ", Provider = " + provider);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/params/shoppinglist3.csv", numLinesToSkip = 1, delimiterString = "___")
    void csvFileSource_StringDoubleIntStringStringDelimiter(String name, double price, int quantity, String uom, String provider)
    {
        System.out.println("Name = " + name + ", Price = " + price + ", Qty = " + quantity + ", UOM = " + uom + ", Provider = " + provider);
    }

    @ParameterizedTest
    @MethodSource(value = "sourceString")
    void methodSource_String(String param1)
    {
        System.out.println("param1 = " + param1);
    }

    List<String> sourceString()
    {
        //processing done here
        return Arrays.asList("tomato", "carrot", "cabbage");
    }

    @ParameterizedTest
    @MethodSource(value = "sourceStringAsStream")
    void methodSource_StringStream(String param1)
    {
        System.out.println("param1 = " + param1);
    }

    Stream<String> sourceStringAsStream()
    {
        //processing
        return Stream.of("Beetroot","apple", "pear");
    }

    @ParameterizedTest
    @MethodSource(value = "sourceList_StringDouble")
    void methodSource_StringDouble(String param1, double param2)
    {
        System.out.println("Param1 = " + param1 + ", param2 = " + param2);
    }

    List<Arguments> sourceList_StringDouble()
    {
        //processing
        return Arrays.asList(arguments("tomato", 2.0), arguments("carrots", 4.5), arguments( "carrots", 4.9));
    }

    @ParameterizedTest
    @MethodSource(value = "junit5tests.ParamProvidor#sourceStream_StringDoubleDeux")
    void methodSource_StringDoubleStream(String param1, double param2)
    {
        System.out.println("Param1 = " + param1 + ", param2 = " + param2);
    }

}
