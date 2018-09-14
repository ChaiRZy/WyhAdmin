package com.feri.wyh10000.admin.mapper;

import com.feri.wyh10000.admin.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int deleteById(Integer id);
    int insert(Role record);
    Role selectById(Integer id);
    int updateById(Role record);
    List<Role> selectByPage(@Param("index") int index, @Param("count") int count);
    int selectCount();
    List<Role> selectAll();
    List<Integer> selectByUid(int uid);
}