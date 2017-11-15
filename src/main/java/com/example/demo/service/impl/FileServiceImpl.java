package com.example.demo.service.impl;

import com.example.demo.dao.file.FileDao;
import com.example.demo.entity.data.ApplyInfo;
import com.example.demo.entity.data.FileData;
import com.example.demo.entity.form.*;
import com.example.demo.enums.FormTypeEnum;
import com.example.demo.service.FileService;
import com.example.demo.service.exception.FileFailException;
import com.example.demo.service.utils.FilePathUtil;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
@PropertySource({"classpath:application.properties"})

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    FileDao fileDao;
    @Autowired
    private org.springframework.core.env.Environment env;
    @Override
    public FileData getFileById(long id) {
        try{
        return fileDao.findFileDataById(id);
    }catch (NullPointerException e){
        throw new FileFailException("找不到你想要的文件");
    }

    }

    @Override
    public void save(FileData fileData) {
        fileDao.save(fileData);

    }

    @Override
    public void delete(FileData fileData) {
        fileDao.delete(fileData);
        //要删除相应的file
    }
    @Override
    public Map<FormTypeEnum,Long> createPdf(ApplyInfo applyInfo){
        Map<FormTypeEnum,Long> stringMap=new HashMap<>();
        if(applyInfo.getFormList()==null){
            return null;
        }
        for (Form form:applyInfo.getFormList()){
            int formId=form.getFormType().ordinal();
           stringMap.put(form.getFormType(),form2pdf(form,formId,applyInfo.getId())) ;

        }
        return stringMap;
    }

//    @Override
//    public Map<FormTypeEnum,Long> createPdf(ApplyInfo applyInfo){
//        Map<FormTypeEnum,Long> stringMap=new HashMap<>();
//
//        long apply_id=applyInfo.getId();
//        Form1 form1=applyInfo.getForm1();
//        Form2 form2=applyInfo.getForm2();
//        Form3 form3=applyInfo.getForm3();
//        Form4 form4=applyInfo.getForm4();
//        Form5 form5=applyInfo.getForm5();
//        Form6 form6=applyInfo.getForm6();
//        Form7 form7=applyInfo.getForm7();
//        if(form1!=null){
//            stringMap.put(FormTypeEnum.特种设备使用登记表一,form2pdf(form1,1,apply_id));
//        }
//        if(form2!=null){
//            stringMap.put(FormTypeEnum.特种设备使用登记表二,form2pdf(form2,2,apply_id));
//        }
//        if(form3!=null){
//            stringMap.put(FormTypeEnum.特种设备使用登记表三,form2pdf(form3,3,apply_id));
//
//        }
//        if(form4!=null){
//            stringMap.put(FormTypeEnum.特种设备使用登记证变更证明,form2pdf(form4,4,apply_id));
//
//        }
//        if(form5!=null){
//            stringMap.put(FormTypeEnum.特种设备停用报废注销登记表,form2pdf(form5,5,apply_id));
//
//        }
//        if(form6!=null){
//            stringMap.put(FormTypeEnum.压力管道基本信息汇总表,form2pdf(form6,6,apply_id));
//
//        }
//        if(form7!=null){
//            stringMap.put(FormTypeEnum.气瓶基本信息汇总表,form2pdf(form7,7,apply_id));
//
//        }
//
//        return stringMap;
//    }
    @Override
    public long form2pdf(Object form, int formType,long applyId) {
        JSONObject jsonObject=new JSONObject(form);
        long file_id=applyId*100+formType;
        String path= FilePathUtil.getPathById(file_id);
        CloseableHttpClient client= HttpClients.createDefault();
        try {
            String url=env.getProperty("custome.fileConverter.serverUrl");
            System.out.println(url);
            HttpPost request = new HttpPost(url+formType);

            StringEntity params = new StringEntity(jsonObject.toString(),Charset.forName("UTF-8"));

            request.addHeader("content-type", "application/json; charset=utf-8");

            request.setEntity(params);
            CloseableHttpResponse response=client.execute(request);
            if(response.getStatusLine().getStatusCode()==200){
               InputStream is= response.getEntity().getContent();
                FileOutputStream fos=new FileOutputStream(new File(path));
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }
                is.close();
                fos.close();
                client.close();
            }
            else {
                throw new Exception();
           }

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("can not connect to file converter service");
            file_id=0;
            //throw ex;
        } finally {
            return file_id;
        }

    }
}
