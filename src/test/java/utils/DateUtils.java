package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    private static final int MillisInDayCount =  86400000;
    private static final String ProjectDateFormat = "MMM dd, yyyy h:mm";

    public static int getDaysToDate(String date){
        Date fundDate = null;
        Date today = new Date();
        SimpleDateFormat format = new SimpleDateFormat(ProjectDateFormat, Locale.ENGLISH);
        try {
            fundDate = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return (int) ((fundDate.getTime() - today.getTime()) / MillisInDayCount);
    }
}
