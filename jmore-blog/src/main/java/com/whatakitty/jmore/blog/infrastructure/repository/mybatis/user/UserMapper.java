package com.whatakitty.jmore.blog.infrastructure.repository.mybatis.user;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserDO record);

    int insertSelective(UserDO record);

    UserDO selectByPrimaryKey(Long id);

    UserDO selectDetailedByPrimaryKey(Long id);

    UserDO selectAllByPrimaryKey(Long id);

    UserDO selectByUsername(@Param("username") String username);

    int updateByPrimaryKeySelective(UserDO record);

    int updateByPrimaryKey(UserDO record);
}