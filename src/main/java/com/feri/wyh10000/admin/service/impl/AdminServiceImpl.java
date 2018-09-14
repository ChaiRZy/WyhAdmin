package com.feri.wyh10000.admin.service.impl;

import com.feri.wyh10000.admin.entity.Admin;
import com.feri.wyh10000.admin.entity.AdminRole;
import com.feri.wyh10000.admin.mapper.AdminMapper;
import com.feri.wyh10000.admin.mapper.AdminRoleMapper;
import com.feri.wyh10000.admin.service.AdminService;
import com.feri.wyh10000.admin.util.ResultUtil;
import com.feri.wyh10000.admin.vo.PageVo;
import com.feri.wyh10000.admin.vo.R;
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
    @Autowired
    private AdminRoleMapper adminRoleMapper;

    @Override
    public R save(Admin admin) {
        return ResultUtil.createResult(adminMapper.insert(admin));
    }

    @Override
    public boolean save1(Admin admin) {
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
    //存在就返回false不可用  不存在就返回true
    @Override
    public boolean checkName(String name) {
        Admin user=adminMapper.selectByName(name);
        if(user!=null){
            //存在
            return false;
        }else {
            //不存在
            return true;
        }
    }
    @Override
    public boolean updateRole(int[] rids, int uid) {
        try{
            adminRoleMapper.deleteByAid(uid);
            for(int id:rids){
                AdminRole ur=new AdminRole();
                ur.setRid(id);
                ur.setAid(uid);
                adminRoleMapper.insert(ur);
            }
            return true;
        }catch (Exception e){
            //记录异常日志
            //return false;
            throw  new RuntimeException("异常");
        }
    }

}
