package com.news.mapper;

import com.news.pojo.FunctionInfo;
import com.news.pojo.FunctionInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FunctionInfoMapper {
    long countByExample(FunctionInfoExample example);

    int deleteByExample(FunctionInfoExample example);

    int deleteByPrimaryKey(Integer functionId);

    int insert(FunctionInfo record);

    int insertSelective(FunctionInfo record);

    List<FunctionInfo> selectByExample(FunctionInfoExample example);

    FunctionInfo selectByPrimaryKey(Integer functionId);

    int updateByExampleSelective(@Param("record") FunctionInfo record, @Param("example") FunctionInfoExample example);

    int updateByExample(@Param("record") FunctionInfo record, @Param("example") FunctionInfoExample example);

    int updateByPrimaryKeySelective(FunctionInfo record);

    int updateByPrimaryKey(FunctionInfo record);
}