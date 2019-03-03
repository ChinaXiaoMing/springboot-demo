package com.nexwise.service;

import com.github.pagehelper.PageInfo;
import com.nexwise.dao.database1.UserMapper;
import com.nexwise.entity.User;
import com.nexwise.entity.UserExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl {

    @Autowired
    UserMapper userMapper;

    public PageInfo<User> findUserByPage(int start, int pageSize) {
        UserExample userExample = new UserExample();
        List<User> list = userMapper.selectByExampleWithRowbounds(userExample,new RowBounds((start - 1) * pageSize, pageSize));
        PageInfo<User> pageInfo = new PageInfo<User>(list);
        long total = userMapper.countByExample(userExample);
        pageInfo.setTotal(total);
        return pageInfo;
    }

    public User findUserById(long id) {
        return userMapper.selectByPrimaryKey(id);
    }

}
