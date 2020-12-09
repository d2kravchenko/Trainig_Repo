package utils;

public class StringHelper {

    /** **********************************************
     Removes all characters befor first founded digit
     @param incomingString - incoming string to process.
     @return - a string with removed chars before first founded digit.
     For example: "Price: 999 USD" -> "999 USD"
     ************************************************/
    public static String removeAllBeforeDigits(String incomingString){
        int cutIndex = 0;
        for (Character character : incomingString.toCharArray()) {
            if(Character.isDigit(character)){
                cutIndex = incomingString.indexOf(character);
                break;
            }
        }
        return incomingString.substring(cutIndex);
    }
}
