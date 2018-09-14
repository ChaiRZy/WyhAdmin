package com.feri.wyh10000.admin.mapper;

import com.feri.wyh10000.admin.entity.RoleResource;

public interface RoleResourceMapper {
    int deleteByRid(Integer id);
    int deleteById(Integer id);
    int insert(RoleResource record);

}