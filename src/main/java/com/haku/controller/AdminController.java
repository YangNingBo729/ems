package com.haku.controller;

import com.haku.entity.Admin;
import com.haku.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    @ResponseBody
    public Object login(Admin admin){
        boolean b = adminService.login(admin);
        Map<String, String> map = new HashMap<>();
        if(b){
            map.put("code", "200");
            map.put("msg", "登录成功");
        }else{
            map.put("code", "500");
            map.put("msg", "用户名或密码错误！");
        }
        return map;
    }

    @RequestMapping("/regist")
    @ResponseBody
    public Object regist(Admin admin, String safeCode, HttpSession session){
        String realCode = (String) session.getAttribute("realCode");
        Map<String, String> map = new HashMap<>();
        if(safeCode.equals(realCode)){
            Integer i = adminService.regist(admin);
            if(i==1){
                map.put("code", "200");
                map.put("msg", "注册成功");
            }else{
                map.put("code", "500");
                map.put("msg", "注册失败");
            }
        }else{
            map.put("code", "505");
            map.put("msg", "验证码错误！");
        }
        return map;
    }
}
