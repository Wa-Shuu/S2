package com.washuu.s2.mapper;

import com.washuu.s2.domain.Reply;
import com.washuu.s2.domain.ReplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReplyMapper {
    long countByExample(ReplyExample example);

    int deleteByExample(ReplyExample example);

    int deleteByPrimaryKey(Integer rid);

    int insert(Reply row);

    int insertSelective(Reply row);

    List<Reply> selectByExample(ReplyExample example);

    Reply selectByPrimaryKey(Integer rid);

    int updateByExampleSelective(@Param("row") Reply row, @Param("example") ReplyExample example);

    int updateByExample(@Param("row") Reply row, @Param("example") ReplyExample example);

    int updateByPrimaryKeySelective(Reply row);

    int updateByPrimaryKey(Reply row);
}