package com.example.demo.service.staticfunction;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.shiro.crypto.hash.Md5Hash;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by yang on 2017/9/12.
 */

public class UtilServiceImpl  {

    public static String encryptPWD(String password,String credential) {
        Md5Hash md5Hash=new Md5Hash(password,credential,2);
        return md5Hash.toString();
    }


    public static String getRandomString()
    {
        return RandomStringUtils.randomAlphanumeric(5);
    }


    public static  Date string2Date(String time, String formatType) throws ParseException {
        SimpleDateFormat formater=new SimpleDateFormat(formatType);
        Date date=null;
        date=formater.parse(time);
        return date;
    }


    public static long date2Long(Date time) {
        return time.getTime();
    }

    public static long string2Long(String strTime, String formatType)
            throws ParseException {
        Date date = string2Date(strTime, formatType); // String类型转成date类型
        if (date == null) {
            return 0;
        } else {
            long currentTime = date2Long(date); // date类型转成long类型
            return currentTime;
        }
    }
    public static  Date long2Date(long time, String formatType) throws ParseException {
        Date dateOld=new Date(time);
        SimpleDateFormat formater=new SimpleDateFormat(formatType);
        String sDateTime = date2String(dateOld, formatType);
        Date date = string2Date(sDateTime, formatType);
        return date;
    }
    public static String date2String(Date time, String formatType) throws ParseException{
        return new SimpleDateFormat(formatType).format(time);
    }

}
