package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    private static final int MILLIS_IN_DAY_COUNT =  86400000;
    private static final String PROJECT_DATE_FORMAT = "MMM dd, yyyy h:mm";

    public static int getDaysToDate(String date){
        Date fundDate = null;
        Date today = new Date();
        SimpleDateFormat format = new SimpleDateFormat(PROJECT_DATE_FORMAT, Locale.ENGLISH);
        try {
            fundDate = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return (int) ((fundDate.getTime() - today.getTime()) / MILLIS_IN_DAY_COUNT);
    }
}
