package com.example.insurancecampaign.Utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    static final String DATE_FORMAT ="yyyy/MM/dd hh:mm";

    public static Date getCurrentDate() throws ParseException {
        Date now = new Date();
        DateFormat dateFormat= new SimpleDateFormat(DATE_FORMAT);
         return dateFormat.parse(dateFormat.format(now));
    }


}
