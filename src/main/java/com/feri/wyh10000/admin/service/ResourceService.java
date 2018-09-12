package com.feri.wyh10000.admin.service;

import com.feri.wyh10000.admin.entity.Resource;
import com.feri.wyh10000.admin.vo.PageVo;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/9/12 11:21
 */
public interface ResourceService {
    boolean save(Resource resource);
    PageVo<Resource> queryByPage(int page, int limit);
    List<Resource> queryAll(int type);


}
