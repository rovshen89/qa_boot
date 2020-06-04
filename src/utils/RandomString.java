package utils;

import java.util.Random;

public class RandomString {
    public String genRandom(int length){
        int leftLimit = 97;
        int rightLimit = 122;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit+1)
                .limit(5)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();


    }
}
