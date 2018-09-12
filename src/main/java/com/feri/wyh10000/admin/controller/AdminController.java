package com.feri.wyh10000.admin.controller;

import com.feri.wyh10000.admin.entity.Admin;
import com.feri.wyh10000.admin.service.AdminService;
import com.feri.wyh10000.admin.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *@Author feri
 *@Date Created in 2018/9/12 11:33
 */
@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    //新增
    @RequestMapping("/adminsave.do")
    public String add(Admin admin){
        if(adminService.save(admin)){
            return "adminlist.html";
        }else {
            return "adminadd.html";
        }
    }
    //查询
    @RequestMapping("/adminpage.do")
    @ResponseBody
    public PageVo<Admin> page(int page, int limit){
      return adminService.queryByPage(page,limit);
    }
}
