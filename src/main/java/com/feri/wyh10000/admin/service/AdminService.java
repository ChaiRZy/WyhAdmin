package com.feri.wyh10000.admin.service;

import com.feri.wyh10000.admin.entity.Admin;
import com.feri.wyh10000.admin.vo.PageVo;
import com.feri.wyh10000.admin.vo.R;

/**
 *@Author feri
 *@Date Created in 2018/9/12 11:21
 */
public interface AdminService {
    R save(Admin admin);
    boolean save1(Admin admin);
    PageVo<Admin> queryByPage(int page, int limit);

    Admin login(String name,String password);
    boolean checkName(String name);
    boolean updateRole(int[] rids,int uid);

}
