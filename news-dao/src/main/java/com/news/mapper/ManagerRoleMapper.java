package com.news.mapper;

import com.news.pojo.ManagerRole;
import com.news.pojo.ManagerRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ManagerRoleMapper {
    long countByExample(ManagerRoleExample example);

    int deleteByExample(ManagerRoleExample example);

    int insert(ManagerRole record);

    int insertSelective(ManagerRole record);

    List<ManagerRole> selectByExample(ManagerRoleExample example);

    int updateByExampleSelective(@Param("record") ManagerRole record, @Param("example") ManagerRoleExample example);

    int updateByExample(@Param("record") ManagerRole record, @Param("example") ManagerRoleExample example);
}