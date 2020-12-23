package utils.generator;

import java.util.Random;

public class StringGenerator {

    public static String getRandomLettersString(int count){

        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        Random random = new Random();
        String output = "";

        for (int i = 0; i < count; i++) {
            char c = chars[random.nextInt(chars.length)];
            output = output + c;
        }

        return output;
    }

    public static String getRandomString(int count){

        char[] chars = "1234567890abcdefghijklmnopqrstuvwxyz".toCharArray();
        Random random = new Random();
        String output = "";

        for (int i = 0; i < count; i++) {
            char c = chars[random.nextInt(chars.length)];
            output = output + c;
        }

        return output;
    }


}
