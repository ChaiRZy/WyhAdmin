package com.feri.wyh10000.admin.service;

import com.feri.wyh10000.admin.entity.Resource;
import com.feri.wyh10000.admin.vo.MenuVo;
import com.feri.wyh10000.admin.vo.PageVo;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/9/12 11:21
 */
public interface ResourceService {
    List<MenuVo> queryByUserName(String name);
    //新增
    boolean save(Resource resource);
    //查询一级菜单
    List<Resource> queryFirstMenu();
    PageVo<Resource> queryByPage(int page, int count);

    List<Resource> selectByAid(int uid);



}
