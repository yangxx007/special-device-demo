package com.example.demo.service.staticfunction;

import com.example.demo.entity.deviceModel.DeviceStatus;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfWriter;
import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
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
    public static BufferedImage getImage(String path) throws Exception {
        File cache=new File(path+"s");
        File file = new File(path);
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        FileChannel channel = raf.getChannel();
        ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
        PDFFile pdffile = new PDFFile(buf);

        // draw the first page to an image
        PDFPage page = pdffile.getPage(0);

        //get the width and height for the doc at the default zoom
        Rectangle rect = new Rectangle(0, 0,
                (int) page.getBBox().getWidth(),
                (int) page.getBBox().getHeight());

        //generate the image
        Image img = page.getImage(
                rect.width, rect.height, //width & height
                rect, // clip rect
                null, // null for the ImageObserver
                false, // fill background with white
                true  // block until drawing is done
        );
        return UtilServiceImpl.toBufferedImage(img);
    }
    public static FileInputStream getFileStream(String path){
        try{File file=new File(path);
        return new FileInputStream(file);
        }catch (Exception e){
            return null;
        }

    }
    public static byte[] readStream(InputStream inStream) {
        ByteArrayOutputStream bops = new ByteArrayOutputStream();
        int data = -1;
        try {
            while((data = inStream.read()) != -1){
                bops.write(data);
            }
            return bops.toByteArray();
        }catch(Exception e){
            return null;
        }
    }
}
