package com.opencode.dao;

import com.opencode.entity.User;
import com.opencode.entity.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 用户映射器
 *
 * @author fu.yuanming
 * @date 2021-07-15
 */
public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectUserByUsername(String username);
}