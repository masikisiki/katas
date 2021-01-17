package za.co.sikza.apps.katas;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DenominatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2", "1,2,3", "1,2,3,4"})
    void givenNoDenominatorReturnMinust1(String input) {
        //arrange
        var array = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        //act
        var sut = new Denominator();
        //assert
        var result = sut.solution(array);
        assertEquals(-1, result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,4,2,2:1", "1,3,4,2,3,3,1,3,3,3:1", "1,5,5,5,5,1:1"}, delimiter = ':')
    void givenOnlyOneNumberIsDenominatorReturnNumber(String input, int expeced) {
        //arrange
        var array = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        //act
        var sut = new Denominator();
        //assert
        var result = sut.solution(array);
        assertEquals(result, expeced);
    }
}
