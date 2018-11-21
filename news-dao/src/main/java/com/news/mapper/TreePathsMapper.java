package com.news.mapper;

import com.news.pojo.TreePaths;
import com.news.pojo.TreePathsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TreePathsMapper {
    long countByExample(TreePathsExample example);

    int deleteByExample(TreePathsExample example);

    int insert(TreePaths record);

    int insertSelective(TreePaths record);

    List<TreePaths> selectByExample(TreePathsExample example);

    int updateByExampleSelective(@Param("record") TreePaths record, @Param("example") TreePathsExample example);

    int updateByExample(@Param("record") TreePaths record, @Param("example") TreePathsExample example);
}