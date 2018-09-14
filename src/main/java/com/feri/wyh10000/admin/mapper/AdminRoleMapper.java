package com.feri.wyh10000.admin.mapper;

import com.feri.wyh10000.admin.entity.AdminRole;

public interface AdminRoleMapper {
    int deleteByAid(int aid);

    int insert(AdminRole adminRole);
}