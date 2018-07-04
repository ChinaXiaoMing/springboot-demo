package com.nexwise.dao;

import com.nexwise.entity.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer id);

    Users selectUserByUsername(String username);

    List<Users> getUserList();

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}