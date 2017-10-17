package com.example.demo.web;

import com.example.demo.entity.dataModel.ApplyInfo;
import com.example.demo.entity.dataModel.FileData;
import com.example.demo.enums.ApplyTypeEnum;
import com.example.demo.enums.FileTypeEnum;
import com.example.demo.enums.JsonResponse;
import com.example.demo.service.ApplyService;
import com.example.demo.service.FileService;

import com.example.demo.service.exception.FileFailException;
import com.example.demo.service.staticfunction.FilePathUtil;
import com.example.demo.service.staticfunction.UtilServiceImpl;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeUtility;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URLEncoder;

import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/file")
public class fileController {
    @Autowired
    private ApplyService applyService;
    @Autowired
    private FileService fileService;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody JsonResponse testUploadFile(HttpServletResponse response,HttpServletRequest req, MultipartHttpServletRequest multiReq, @RequestParam("applyId")
            long apply_id, @RequestParam("fileTypeId") int file_type_id)
            throws
            Exception {
        long file_id = apply_id * 100 + file_type_id;
        FileData fileData = new FileData();
        fileData.setId(file_id);
        fileData.setFileTypeId(file_type_id);
        fileData.setApplyId(apply_id);
        ApplyInfo applyInfo = applyService.findByApplyID(apply_id,SecurityUtils.getSubject().getSession());
//        JSONObject jsonObject = UtilServiceImpl.string2JSON(applyInfo.getFilesId());
        Map<FileTypeEnum,Long> filemap=applyInfo.getFiles();
        String path = FilePathUtil.getPathById(file_id);
        FileOutputStream fos = new FileOutputStream(new File(path));
        MultipartFile file = multiReq.getFile("file");
        fileData.setFileName(file.getOriginalFilename());
//        jsonObject.put(file.getOriginalFilename(), file_id);

        filemap.put(FileTypeEnum.values()[file_type_id],file_id);
        applyInfo.setFiles(filemap);
        FileInputStream fs = (FileInputStream) file.getInputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = fs.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }
        fos.close();
        fs.close();
        applyService.saveApply(applyInfo,SecurityUtils.getSubject().getSession());
        fileService.save(fileData);
        thumbnailImage(response,file_id);
        return new JsonResponse();
    }

    @RequestMapping("/index")
    public String index() {
        return "file";
    }


    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void testDownload(HttpServletRequest request, HttpServletResponse response, @RequestParam("fileId") long
            file_id) throws Exception {

            File file = new File(FilePathUtil.getPathById(file_id));
            //检查applyid是否是下载者的
            //validate.isPermission(SecurityUtils.getSubject(),fileService.getFileById(file_id).getApplyId());
        try {
            String agent = request.getHeader("User-Agent");
            FileData fileData = fileService.getFileById(file_id);
            String fileName = fileData.getFileName();
            if (agent.contains("Firefox"))
                fileName = MimeUtility.encodeWord(fileName);
            else
                fileName = URLEncoder.encode(fileName, "utf-8").replaceAll("\\+", "%20");
            response.setHeader("content-type", "application/octet-stream");
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");
            OutputStream os=response.getOutputStream();
            FileInputStream fo=new FileInputStream(file);
            try{
                byte[] bis=UtilServiceImpl.readStream(fo);
                os.write(bis);
                os.flush();
            } catch (Exception e) {
                throw e;
            }finally {
                fo.close();
                os.close();
            }

        } catch (Exception e) {
           throw new FileFailException(e.getMessage());
        }


    }

    @RequestMapping(value = "/preview", method = RequestMethod.GET)
    void  preview(HttpServletRequest request, HttpServletResponse response, @RequestParam("fileId") long
            file_id)
            throws Exception {
        File file = new File(FilePathUtil.getPathById(file_id));
        //检查applyid是否是下载者的
        //validate.isPermission(SecurityUtils.getSubject(),fileService.getFileById(file_id).getApplyId());
        String agent = request.getHeader("User-Agent");
        FileData fileData = fileService.getFileById(file_id);
        //String fileName = fileData.getFileName();
        String fileName = "test";
        response.setHeader("content-type", "application/pdf");
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline;filename=\"" + fileName + "\"");
        OutputStream os=response.getOutputStream();
        FileInputStream fo=new FileInputStream(file);
        try{
            byte[] bis=UtilServiceImpl.readStream(fo);
            os.write(bis);
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }finally {
            fo.close();
            os.close();
        }



    }

    @RequestMapping("/thumbnail")
    public void thumbnailImage(HttpServletResponse response, @RequestParam("fileId") long
            file_id) throws Exception {
        String path = FilePathUtil.getPathById(file_id);
        response.setDateHeader("Expires", UtilServiceImpl.date2Long(new Date()) + 156000);
        response.setHeader("Cache-Control", "public,max-age=156000");
        // response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        //response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        ServletOutputStream out = response.getOutputStream();
        FileInputStream imageCache= UtilServiceImpl.getFileStream(path+"p");
        //以后的path就用缓存去记录，主要是想要用缓存的expire时间以及缓存刷新。
        if(imageCache!=null)
        {
            byte[] btImg = UtilServiceImpl.readStream(imageCache);

            out.write(btImg);
        }
        else {

            File file = new File(path + "p");
            BufferedImage image = null;
            try {
                image = UtilServiceImpl.getImage(path);
            } catch (Exception e) {
                //catch pdf cannot parse Exception
                UtilServiceImpl.fixpdf(path, new FileOutputStream(file));
                image = UtilServiceImpl.getImage(path + "p");
            }

            ImageIO.write(image, "jpg", out);
            ImageIO.write(image, "jpg", file);
        }
        out.flush();
        out.close();

    }


    @RequestMapping("/test")
    public @ResponseBody JsonResponse test(){
//        UserInfo fileData=new UserInfo();
//        fileData.setUsername("admin");
//        List<SysRole> sysRoles=new ArrayList<>();
//        sysRoles.add(new SysRole());
//        fileData.setRoleList(sysRoles);
//        redisTemplate.opsForHash().put("image","1",fileData);
//        //redisTemplate.opsForHash().put("image","2","image2's path");
//        System.out.println(redisTemplate.opsForHash().get("image","1"));
//        //System.out.println(redisTemplate.opsForHash().entries("image"));
        return new JsonResponse();
    }
}
