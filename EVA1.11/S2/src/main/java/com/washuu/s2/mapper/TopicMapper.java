package com.washuu.s2.mapper;

import com.washuu.s2.domain.Topic;
import com.washuu.s2.domain.TopicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TopicMapper {
    long countByExample(TopicExample example);

    int deleteByExample(TopicExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(Topic row);

    int insertSelective(Topic row);

    List<Topic> selectByExample(TopicExample example);

    Topic selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("row") Topic row, @Param("example") TopicExample example);

    int updateByExample(@Param("row") Topic row, @Param("example") TopicExample example);

    int updateByPrimaryKeySelective(Topic row);

    int updateByPrimaryKey(Topic row);
}