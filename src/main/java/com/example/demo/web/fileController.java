package com.example.demo.web;

import com.example.demo.entity.dataModel.ApplyInfo;
import com.example.demo.entity.dataModel.FileData;
import com.example.demo.enums.JsonResponse;
import com.example.demo.service.ApplyService;
import com.example.demo.service.FileService;
import com.example.demo.service.staticfunction.FilePathUtil;
import com.example.demo.service.staticfunction.UtilServiceImpl;
import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeUtility;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Date;

@Controller
@RequestMapping("/file")
public class fileController {
    @Autowired
    private ApplyService applyService;
    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public void testUploadFile(HttpServletRequest req, MultipartHttpServletRequest multiReq, @RequestParam("applyId")
            long apply_id, @RequestParam("fileTypeId") int file_type_id)
            throws
            IOException {
        long file_id = apply_id * 100 + file_type_id;
        FileData fileData = new FileData();
        fileData.setId(file_id);
        fileData.setFileTypeId(file_type_id);
        fileData.setApplyId(apply_id);
        ApplyInfo applyInfo = applyService.findByApplyID(apply_id);
        //applyInfo null exception
        JSONObject jsonObject = UtilServiceImpl.string2JSON(applyInfo.getFilesId());
        jsonObject.put(file_type_id + "", file_id);
        applyInfo.setFilesId(jsonObject.toString());
        String path = FilePathUtil.getPathById(file_id);
        FileOutputStream fos = new FileOutputStream(new File(path));
        MultipartFile file = multiReq.getFile("file");
        fileData.setFileName(file.getOriginalFilename());
        FileInputStream fs = (FileInputStream) file.getInputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = fs.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }
        fos.close();
        fs.close();
        applyService.saveApply(applyInfo);
        fileService.save(fileData);
    }

    @RequestMapping("/index")
    public String index() {
        return "file";
    }


    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void testDownload(HttpServletRequest request, HttpServletResponse response, @RequestParam("fileId") long
            file_id) {
        try {
            File file = new File(FilePathUtil.getPathById(file_id));
            //检查applyid是否是下载者的
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
            byte[] buff = new byte[1024];
            BufferedInputStream bis = null;
            OutputStream os = null;
            try {
                os = response.getOutputStream();
                bis = new BufferedInputStream(new FileInputStream(file));
                int i = bis.read(buff);
                while (i != -1) {
                    os.write(buff, 0, buff.length);
                    os.flush();
                    i = bis.read(buff);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(value = "/preview", method = RequestMethod.GET)
    public void preview(HttpServletRequest request, HttpServletResponse response, @RequestParam("fileId") long
            file_id)
            throws IOException {
        File file = new File(FilePathUtil.getPathById(file_id));
        //检查applyid是否是下载者的
        String agent = request.getHeader("User-Agent");
        FileData fileData = fileService.getFileById(file_id);
        String fileName = fileData.getFileName();
        response.setHeader("content-type", "application/pdf");
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline;filename=\"" + fileName + "\"");
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(file));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            bis.close();
            os.close();
        }


    }

    @RequestMapping("/thumbnail")
    public void thumbnailImage(HttpServletResponse response, @RequestParam("fileId") long
            file_id) throws Exception {
        String path = FilePathUtil.getPathById(file_id);
        File file = new File(path + "s");
        BufferedImage image = null;
        try {
            image = getImage(path);
        } catch (Exception e) {
            //catch pdf cannot parse Exception
            UtilServiceImpl.fixpdf(path, new FileOutputStream(file));
            image = getImage(path + "s");
        }

        response.setDateHeader("Expires", UtilServiceImpl.date2Long(new Date()) + 156000);
        response.setHeader("Cache-Control", "public,max-age=156000");
        // response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        //response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        out.flush();
        out.close();
        if (file.exists())
            file.delete();
    }

    public BufferedImage getImage(String path) throws Exception {
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
                true, // fill background with white
                true  // block until drawing is done
        );
        return UtilServiceImpl.toBufferedImage(img);
    }
    @RequestMapping("/test")
    public @ResponseBody JsonResponse test(){
        return new JsonResponse(true,null,"{[]}");
    }
}
