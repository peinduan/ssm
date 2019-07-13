package cn.it.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String date2String(Date date,String pattern){
        return new SimpleDateFormat(pattern).format(date);
    }

    public static Date string2Date(String date,String pattern) throws ParseException {
        return new SimpleDateFormat(pattern).parse(date);
    }
}
