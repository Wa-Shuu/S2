package com.washuu.s2.mapper;

import com.washuu.s2.domain.College;
import com.washuu.s2.domain.CollegeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollegeMapper {
    long countByExample(CollegeExample example);

    int deleteByExample(CollegeExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(College row);

    int insertSelective(College row);

    List<College> selectByExample(CollegeExample example);

    College selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("row") College row, @Param("example") CollegeExample example);

    int updateByExample(@Param("row") College row, @Param("example") CollegeExample example);

    int updateByPrimaryKeySelective(College row);

    int updateByPrimaryKey(College row);
}