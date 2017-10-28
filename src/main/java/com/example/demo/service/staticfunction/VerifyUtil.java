package com.example.demo.service.staticfunction;

import com.example.demo.entity.data.ApplyInfo;
import com.example.demo.service.exception.VerifyFailException;

import java.lang.reflect.Field;
import java.util.List;
import java.util.regex.Pattern;

public class VerifyUtil {
    public final static int USERNAME=1;
    public final static int PASSWORD=2;
    public final static int EMAIL=3;
    public final static int PHONE=4;
    public final static int MOBILE_PHONE=5;
    public final static int CITIZEN_ID=6;
    public final static int COMPANY_ID=7;
    public final static int WORK_ID=8;
    public final static int CHN_NAME=9;
    public static boolean verify(String verifyStr,int verifyType){
        if(verifyStr.isEmpty())
            return false;
        switch (verifyType){
            case 1:
                if(!Pattern.matches("\\w{5,15}",verifyStr))
                    return false;
                else
                    return true;
            case 2:
                if(!Pattern.matches("\\w{5,15}",verifyStr))
                    return false;
                else
                    return true;
            case 3:
                if(!Pattern.matches("\\w+@\\w+\\.\\w+",verifyStr))
                    return false;
                else
                    return true;
            case 4:
                if(!Pattern.matches("1[3458]\\d{9}$",verifyStr))
                    return false;
                else
                    return true;
            case 5:
                if(!Pattern.matches("\\d{11}",verifyStr))
                    return false;
                else
                    return true;
            case 6:
                if(!Pattern.matches("[1-9]\\d{13,16}[a-zA-Z0-9]{1}",verifyStr))
                    return false;
                else
                    return true;
            case 7:
                if(!Pattern.matches("\\w{5,15}",verifyStr))
                    return false;
                else
                    return true;
            case 8:
                if(!Pattern.matches("\\d{5,15}",verifyStr))
                    return false;
                else
                    return true;
            case 9:
                if(!Pattern.matches("^[\u4E00-\u9FA5]+$",verifyStr))
                    return false;
                else
                    return true;

            default:
                return false;
        }

    }
    public static void verifyApply(List<String> exceptFields, ApplyInfo applyInfo)throws Exception{
        for(Field field: applyInfo.getClass().getDeclaredFields()){
            field.setAccessible(true);
//            System.out.println(field.getName());
//            System.out.println(field.get(applyInfo));
            if(!exceptFields.contains(field.getName())) {
                if (field.get(applyInfo) == null) {
                    throw new VerifyFailException("表单没有填完");
                }
            }
        }
    }

}
