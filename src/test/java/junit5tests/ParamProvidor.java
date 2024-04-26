package junit5tests;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ParamProvidor {

    static Stream<Arguments> sourceStream_StringDoubleDeux()
    {
        return Stream.of(arguments("apple", 8.9), arguments("pear", 6.6));
    }
}
