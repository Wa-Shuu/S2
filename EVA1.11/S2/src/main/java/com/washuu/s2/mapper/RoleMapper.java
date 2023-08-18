package com.washuu.s2.mapper;

import com.washuu.s2.domain.Role;
import com.washuu.s2.domain.RoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    long countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Integer rid);

    int insert(Role row);

    int insertSelective(Role row);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer rid);

    int updateByExampleSelective(@Param("row") Role row, @Param("example") RoleExample example);

    int updateByExample(@Param("row") Role row, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role row);

    int updateByPrimaryKey(Role row);
}