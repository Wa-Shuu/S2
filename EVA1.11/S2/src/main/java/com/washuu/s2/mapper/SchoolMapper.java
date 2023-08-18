package com.washuu.s2.mapper;

import com.washuu.s2.domain.School;
import com.washuu.s2.domain.SchoolExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SchoolMapper {
    long countByExample(SchoolExample example);

    int deleteByExample(SchoolExample example);

    int deleteByPrimaryKey(Integer sid);

    int insert(School row);

    int insertSelective(School row);

    List<School> selectByExample(SchoolExample example);

    School selectByPrimaryKey(Integer sid);

    int updateByExampleSelective(@Param("row") School row, @Param("example") SchoolExample example);

    int updateByExample(@Param("row") School row, @Param("example") SchoolExample example);

    int updateByPrimaryKeySelective(School row);

    int updateByPrimaryKey(School row);
}