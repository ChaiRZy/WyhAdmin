package com.feri.wyh10000.font.service.impl;

import com.feri.wyh10000.admin.vo.PageVo;
import com.feri.wyh10000.admin.vo.R;
import com.feri.wyh10000.font.mapper.UserMapper;
import com.feri.wyh10000.font.service.UserService;
import com.wyh10000.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *@Author feri
 *@Date Created in 2018/9/14 17:10
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public PageVo<User> queryPage(int page, int limit) {
        return null;
    }

    @Override
    public R updateFlag(int uid, int flag) {
        return null;
    }
}
