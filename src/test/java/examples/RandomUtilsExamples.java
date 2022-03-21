package examples;

import org.junit.jupiter.api.Test;

import static utils.RandomUtils.*;

public class RandomUtilsExamples {

    @Test
    void randomUtilsExamples() {
        System.out.println(getRandomString(10));
        System.out.println(getRandomInt(-10, 10));
        System.out.println(getRandomLong(10, 10000));
    }
}
