package utils;

import java.util.Random;

public class GenerateData {

    private static final Random random = new Random();

    /** **********************************************
     Generate string of $min to $max chars with spaces
     @param countMin - minimum characters count in string
     @param countMax - maximum characters count in string
     @return - a string consisting of numbers and symbols of the English alphabet, randomly separated with spaces. Char
     after space is in uppercase. String lenght is random number between countMin and countMax.
    ************************************************/

    public static String getRandomText(int countMin, int countMax){
        boolean nextUpper = true;
        if (countMin >= countMax || countMin < 0 || countMax > 1000) {
            countMin = 25;
            countMax = 100;
        }
        char[] chars = "1234567890abcdefghijklmnopqrstuvwxyz".toCharArray();
        String output = "";
        for (int i = countMin; i <= countMax; i++) {
            char nextChar = chars[random.nextInt(chars.length)];
            if (nextUpper) {
                nextChar = Character.toUpperCase(nextChar);
                nextUpper = false;
            }
            output = output + nextChar;
            if (random.nextInt(100) <= 20 && i != countMax) { //20% chance to separate with a space and set next char to Uppercase
                output = output + " ";
                nextUpper = true;
            }
        }
        return output;
    }
}
