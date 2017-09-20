package com.example.demo.web;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.util.Date;
@Controller
@RequestMapping("/util")
public class UtilController {
    @Autowired
    public Producer captchaProducer;
    @RequestMapping(value = "/image", method = RequestMethod.GET)
    public String image() {
        return "image";
    }

    @RequestMapping(value = "/captchaimage")
    @ResponseBody
    public void getKaptchaImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        String capText = captchaProducer.createText();// 生成验证码字符串
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        System.out.println(capText);
        Date time = new Date();
        session.setAttribute("kaptcha_create_time", time.getTime());
        //Cookie cookie = new Cookie(Constants.KAPTCHA_SESSION_KEY, capText); // 生成cookie
        //cookie.setMaxAge(30); // 300秒生存期
        //response.addCookie(cookie); // 将cookie加入response
        BufferedImage bi = captchaProducer.createImage(capText);// 生成验证码图片
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }

    }
}
