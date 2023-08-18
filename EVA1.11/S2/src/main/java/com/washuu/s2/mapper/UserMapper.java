package com.washuu.s2.mapper;

import com.washuu.s2.domain.User;
import com.washuu.s2.domain.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int insert(User row);

    int insertSelective(User row);

    List<User> selectByExample(UserExample example);

    int updateByExampleSelective(@Param("row") User row, @Param("example") UserExample example);

    int updateByExample(@Param("row") User row, @Param("example") UserExample example);
}