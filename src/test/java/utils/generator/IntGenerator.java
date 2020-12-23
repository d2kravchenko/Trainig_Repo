package utils.generator;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.logging.Logger;

import java.util.Random;

public class IntGenerator {

    private static final Logger logger = AqualityServices.getLogger();


    /* *************************************************************************************************
    Generating 3 random non-repeating numbers between 1 and 20, excluding 18 (it is "Select all" checkbox)
    ***************************************************************************************************/
    public static int[] getSpecificNumber(){
        Random random = new Random();
        int z, x, c;
        do {
            z = random.nextInt(19);
            z++;
        } while ( z == 18 );
        do {
            x = random.nextInt(19);
            x++;
        } while ( x == 18  || x == z );
        do {
            c = random.nextInt(19);
            c++;
        } while ( c == 18 || c  == z || c == x );
        logger.info("Generating 3 random specific numbers : " + z + " , " + x + " , " + c + ".");
        return new int[]{z, x, c};
    }

    public static int getRandomInt(int bound){

        return new Random().nextInt(bound);


    }


}
