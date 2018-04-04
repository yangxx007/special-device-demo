package com.example.demo.service.utils;

import com.example.demo.entity.data.ApplyInfo;

import java.io.File;
import java.util.Map;
import java.util.Set;

public class FilePathUtil {
    public static String getPathById(long id){
        String path=ClassLoader.getSystemResource("").getPath();
        path=path+"..//files//"+id/5000+"//";
        File file=new File(path);
        if(!file.exists())
        {
            file.mkdir();
        }

        return  path+id;
    }
    public static long getFileId(String fileName, ApplyInfo applyInfo){
        long applyId=applyInfo.getId();
        Map<String,Long> files=applyInfo.getFiles();
        if(files.get(fileName)!=null)
        {
            return files.get(fileName);
        }
        else{
            long fileId=applyId*100+30L;
            for(String name:files.keySet()){
                if(files.get(name)>=fileId)
                {
                    fileId=files.get(name)+1;
                }
            }

            files.put(fileName,fileId);
        }
        return files.get(fileName);
    }
}
