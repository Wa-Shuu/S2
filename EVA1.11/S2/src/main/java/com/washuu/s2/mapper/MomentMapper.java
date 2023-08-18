package com.washuu.s2.mapper;

import com.washuu.s2.domain.Moment;
import com.washuu.s2.domain.MomentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MomentMapper {
    long countByExample(MomentExample example);

    int deleteByExample(MomentExample example);

    int deleteByPrimaryKey(Integer mid);

    int insert(Moment row);

    int insertSelective(Moment row);

    List<Moment> selectByExampleWithBLOBs(MomentExample example);

    List<Moment> selectByExample(MomentExample example);

    Moment selectByPrimaryKey(Integer mid);

    int updateByExampleSelective(@Param("row") Moment row, @Param("example") MomentExample example);

    int updateByExampleWithBLOBs(@Param("row") Moment row, @Param("example") MomentExample example);

    int updateByExample(@Param("row") Moment row, @Param("example") MomentExample example);

    int updateByPrimaryKeySelective(Moment row);

    int updateByPrimaryKeyWithBLOBs(Moment row);

    int updateByPrimaryKey(Moment row);
}