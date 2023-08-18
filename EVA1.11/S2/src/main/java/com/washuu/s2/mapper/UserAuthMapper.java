package com.washuu.s2.mapper;

import com.washuu.s2.domain.UserAuth;
import com.washuu.s2.domain.UserAuthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAuthMapper {
    long countByExample(UserAuthExample example);

    int deleteByExample(UserAuthExample example);

    int deleteByPrimaryKey(Integer aid);

    int insert(UserAuth row);

    int insertSelective(UserAuth row);

    List<UserAuth> selectByExample(UserAuthExample example);

    UserAuth selectByPrimaryKey(Integer aid);

    int updateByExampleSelective(@Param("row") UserAuth row, @Param("example") UserAuthExample example);

    int updateByExample(@Param("row") UserAuth row, @Param("example") UserAuthExample example);

    int updateByPrimaryKeySelective(UserAuth row);

    int updateByPrimaryKey(UserAuth row);
}