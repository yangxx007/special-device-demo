package com.example.demo.service.staticfunction;

import com.example.demo.entity.deviceModel.DeviceStatus;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfWriter;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.json.JSONObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
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
    public static JSONObject string2JSON(String str){
        JSONObject jsonObject=null;
        try{
            jsonObject=new JSONObject(str);
        }
        catch (Exception e){
            jsonObject=new JSONObject();
        }
        return jsonObject;
    }
    public static void fixpdf(String path, OutputStream desc)throws Exception{
        PdfReader reader = new PdfReader(path);
        PdfStamper stamper = new PdfStamper(reader, desc);
        stamper.getWriter().setPdfVersion(PdfWriter.PDF_VERSION_1_4);
        stamper.close();
        reader.close();

    }
    public static BufferedImage toBufferedImage(Image img)
    {
        if (img instanceof BufferedImage)
        {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bimage;
    }
    public static String generateDeviceCode(DeviceStatus deviceStatus){
        String deviceShorthand=null;
        String deviceTypeCode=null;
        String agencyProvince=null;
        String agencyCity=null;
        String sequenceNumber=null;
        //last two number
        String year=null;
        String DeviceCode=deviceShorthand+deviceTypeCode+agencyProvince+agencyCity+sequenceNumber+"("+year+")";
        return DeviceCode;
    }
}
