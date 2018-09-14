package com.feri.wyh10000.admin.service;

import com.feri.wyh10000.admin.entity.Role;
import com.feri.wyh10000.admin.vo.PageVo;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/9/12 11:21
 */
public interface RoleService {
    boolean save(Role role);
    PageVo<Role> queryByPage(int page, int limit);
    List<Role> queryAll();
    List<Integer> selectByUid(int uid);

}
