package com.haku.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/captcha")
public class CaptchaController {
    @Autowired
    private HttpSession session;

    @RequestMapping("/captcha")
    public void getCaptcha(HttpServletResponse resp, HttpServletRequest req){
        //1.获得验证码对象
        LineCaptcha captcha = CaptchaUtil.createLineCaptcha(100, 40,4,5);
        //2.获得响应流
        ServletOutputStream os = null ;
        try {
            os = resp.getOutputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //3.将验证码图片写出到输出流
        captcha.write(os);

        //4.获得验证码的值，以json方式返回给页面
        String safeCode = captcha.getCode();

        session.setAttribute("realCode", safeCode);
        System.out.println(session.getAttribute("realCode")+"----------");
    }
}
