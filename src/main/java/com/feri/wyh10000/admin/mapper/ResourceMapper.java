package com.feri.wyh10000.admin.mapper;

import com.feri.wyh10000.admin.entity.Resource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResourceMapper {
    int deleteById(Integer id);
    int insert(Resource record);
    Resource selectById(Integer id);
    int updateById(Resource record);
    List<Resource> queryByUserName(String name);
    List<Resource> selectByPage(@Param("index") int index, @Param("count") int count);
    int selectCount();
    //根据用户查询对应的所有权限
    List<Resource> selectByAid(int aid);
    List<Resource> selectByPid(int id);
}