package com.example.demo.service.staticfunction;

import java.io.File;

public class FilePathUtil {
    public static String getPathById(long id){
        String path=ClassLoader.getSystemResource("").getPath();
        path=path+"..//files//"+id/5000+"//";
        File file=new File(path);
        if(!file.exists())
            file.mkdir();
        return  path+id;
    }
}
