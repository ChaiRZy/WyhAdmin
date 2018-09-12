package com.feri.wyh10000.admin.service.impl;

import com.feri.wyh10000.admin.entity.Admin;
import com.feri.wyh10000.admin.mapper.AdminMapper;
import com.feri.wyh10000.admin.service.AdminService;
import com.feri.wyh10000.admin.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 *@Author feri
 *@Date Created in 2018/9/12 11:25
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {


    @Autowired
    private AdminMapper adminMapper;

    @Override
    public boolean save(Admin admin) {
        return adminMapper.insert(admin)>0;
    }

    @Override
    public PageVo<Admin> queryByPage(int page, int limit) {
        int index=(page-1)*limit;
        return new PageVo<>(adminMapper.selectCount(),adminMapper.selectByPage(index,limit));
    }

    @Override
    public Admin login(String name, String password) {
        Admin admin=adminMapper.selectByName(name);
        if(admin!=null){
            if(Objects.equals(admin.getPassword(),password)){
                return admin;
            }
        }
        return null;
    }
}
