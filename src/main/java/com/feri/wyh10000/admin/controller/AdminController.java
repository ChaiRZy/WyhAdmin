package com.feri.wyh10000.admin.controller;

import com.feri.wyh10000.admin.entity.Admin;
import com.feri.wyh10000.admin.service.AdminService;
import com.feri.wyh10000.admin.service.ResourceService;
import com.feri.wyh10000.admin.vo.MenuVo;
import com.feri.wyh10000.admin.vo.PageVo;
import com.feri.wyh10000.admin.vo.R;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 *@Author feri
 *@Date Created in 2018/9/12 11:33
 */
@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private ResourceService resourceService;
    //新增
    @RequestMapping("/adminsave1.do")
    public String add(Admin admin){
        if(adminService.save1(admin)){
            return "adminlist.html";
        }else {
            return "adminadd.html";
        }
    }
    //左菜单
    @RequestMapping("/usermenus.do")
    @ResponseBody
    public List<MenuVo> queryMenus(){
        Admin user= (Admin) SecurityUtils.getSubject().getSession().getAttribute("admin");
        return resourceService.queryByUserName(user.getName());
    }
    //验证是否存在用户名 存在返回1 不存在返回0
    @RequestMapping("/usercheck.do")
    public R check(String name, HttpServletResponse response) {
        if(adminService.checkName(name)){
           return R.setOK();
        }else {
           return R.setERROR();
        }
    }


    //新增
//    @RequestMapping("/adminsave.do")
//    public R save(Admin admin){
//        return adminService.save(admin);
//    }
    //查询
    @RequestMapping("/adminpage.do")
    public PageVo<Admin> page(int page, int limit){
      return adminService.queryByPage(page,limit);
    }

    @RequestMapping("/adminlogin.do")
    public R login(String name,String password,boolean isrem){
        Admin admin=adminService.login(name,password);
        if(admin!=null){
            Subject subject=SecurityUtils.getSubject();
            subject.getSession().setAttribute("admin",admin);
            UsernamePasswordToken token=new UsernamePasswordToken(name,password,isrem);
            subject.login(token);
            return R.setOK();
        }else {
            return R.setERROR();
        }
    }


}
