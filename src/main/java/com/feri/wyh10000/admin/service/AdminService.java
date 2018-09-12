package com.feri.wyh10000.admin.service;

import com.feri.wyh10000.admin.entity.Admin;
import com.feri.wyh10000.admin.vo.PageVo;

/**
 *@Author feri
 *@Date Created in 2018/9/12 11:21
 */
public interface AdminService {
    boolean save(Admin admin);
    PageVo<Admin> queryByPage(int page, int limit);

    Admin login(String name,String password);

}
