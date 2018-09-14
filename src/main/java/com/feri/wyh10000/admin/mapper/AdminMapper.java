package com.feri.wyh10000.admin.mapper;

import com.feri.wyh10000.admin.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface AdminMapper {
    int insert(Admin record);
    Admin selectById(Integer id);
    int updateFlag(@Param("id")int id,@Param("flag") int flag);
    int updateById(Admin record);
    //查询数量
    int selectCount();

    //分页查询
    List<Admin> selectByPage(@Param("index") int index, @Param("count") int count);

    Admin selectByName(String name);
}