package utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static String getRandomString(int length) {
        return RandomStringUtils.random(length, true, false).toUpperCase();
    }

    public static int getRandomInt(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }

    public static long getRandomLong(int min, int max) {
        return ThreadLocalRandom.current().nextLong(min, max);
    }
}
