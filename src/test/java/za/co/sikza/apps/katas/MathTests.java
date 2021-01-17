package za.co.sikza.apps.katas;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MathTests {


    @Test
    public void addTwoPositiveNumbers(){
        var sut = new MathService();
        Assertions.assertThat(sut.add(1,1)).isEqualTo(2);
    }

    @Test
    public void multipleTwoPositiveNumbers(){
        var sut = new MathService();
        Assertions.assertThat(sut.multiply(1,1)).isEqualTo(1);
    }

}
