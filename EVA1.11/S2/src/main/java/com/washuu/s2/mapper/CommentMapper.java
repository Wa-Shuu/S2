package com.washuu.s2.mapper;

import com.washuu.s2.domain.Comment;
import com.washuu.s2.domain.CommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentMapper {
    long countByExample(CommentExample example);

    int deleteByExample(CommentExample example);

    int deleteByPrimaryKey(Integer comId);

    int insert(Comment row);

    int insertSelective(Comment row);

    List<Comment> selectByExample(CommentExample example);

    Comment selectByPrimaryKey(Integer comId);

    int updateByExampleSelective(@Param("row") Comment row, @Param("example") CommentExample example);

    int updateByExample(@Param("row") Comment row, @Param("example") CommentExample example);

    int updateByPrimaryKeySelective(Comment row);

    int updateByPrimaryKey(Comment row);
}