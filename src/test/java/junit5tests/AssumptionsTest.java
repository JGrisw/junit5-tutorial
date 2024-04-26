package junit5tests;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assumptions.*;

public class AssumptionsTest {

    @ParameterizedTest(name = "Run: {index}  - Value: {arguments}")
    @ValueSource(ints = {1,5,6})
    void intValues(int theParam)
    {
        assumeTrue(theParam > 4);
        System.out.println("theParam = " + theParam);
    }

    @ParameterizedTest
    @CsvSource(value = {"Steve, Rogers", "Tony,Stank", "Peter, Porker"})
    void csvSource_StringString(String param1, String param2)
    {
        assumeFalse(param1.equals("Steve"), "the Assumption failed for the following param2 " + param2);
        System.out.println("Param1 = " + param1 + ", Param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"Steve, 32, true", "Captain, 21, false", "Bucky, 3, true"})
    void csvSource_StringIntBoolean(String param1, int param2, boolean param3)
    {
        assumingThat(param2 > 20, () -> System.out.println("This code ran"));
        System.out.println("Param1 = " + param1 + ", Param2 = " + param2 + ", Param3 = " + param3);
    }
}
