package Generators;

import Configuration.TestConfig;
import aquality.selenium.browser.AqualityServices;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
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
        Boolean nextUpper = true;

        if (countMin >= countMax || countMin < 0 || countMax > 1000) {
            countMin = 25;
            countMax = 100;
        }
        char[] chars = "1234567890abcdefghijklmnopqrstuvwxyz".toCharArray();
        String output = "";
        for (int i = countMin; i <= countMax; i++) {
            char c = chars[random.nextInt(chars.length)];

            if (nextUpper) {
                c = Character.toUpperCase(c);
                nextUpper = false;
            }

            output = output + c;

            if (random.nextInt(100) <= 20 && i!= countMax) { //20% chance to separate with a space and set next char to Uppercase
                output = output + " ";
                nextUpper = true;
            }
        }
        return output;
    }
}
