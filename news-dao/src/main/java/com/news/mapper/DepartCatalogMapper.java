package com.news.mapper;

import com.news.pojo.DepartCatalog;
import com.news.pojo.DepartCatalogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DepartCatalogMapper {
    long countByExample(DepartCatalogExample example);

    int deleteByExample(DepartCatalogExample example);

    int insert(DepartCatalog record);

    int insertSelective(DepartCatalog record);

    List<DepartCatalog> selectByExample(DepartCatalogExample example);

    int updateByExampleSelective(@Param("record") DepartCatalog record, @Param("example") DepartCatalogExample example);

    int updateByExample(@Param("record") DepartCatalog record, @Param("example") DepartCatalogExample example);
}