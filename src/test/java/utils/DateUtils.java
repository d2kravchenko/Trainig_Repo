package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    public static int getSecondsToDate(String date){
        Date fundDate = null;
        Date today = new Date();
        SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy h:mm", Locale.ENGLISH);
        try {
            fundDate = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        double f = (double) (fundDate.getTime() - today.getTime()) / (1000*60*60*24);
        System.out.println(f);
        return (int)(f);


    }




}
