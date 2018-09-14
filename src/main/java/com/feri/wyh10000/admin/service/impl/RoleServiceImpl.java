package com.feri.wyh10000.admin.service.impl;

import com.feri.wyh10000.admin.vo.PageVo;
import com.feri.wyh10000.admin.entity.Role;
import com.feri.wyh10000.admin.mapper.RoleMapper;
import com.feri.wyh10000.admin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/8/15 09:55
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper mapper;
    @Override
    public boolean save(Role role) {
        return mapper.insert(role)>0;
    }

    @Override
    public PageVo<Role> queryByPage(int page, int count) {
        int index=0;
        if(page>0){
            index=(page-1)*count;
        }
        return new PageVo<Role>(mapper.selectCount(),mapper.selectByPage(index,count));
    }

    @Override
    public List<Role> queryAll() {
        return mapper.selectAll();
    }

    @Override
    public List<Integer> selectByUid(int uid) {
        return mapper.selectByUid(uid);
    }
}
