package com.opencode.service;

import com.opencode.dao.UserMapper;
import com.opencode.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现类
 *
 * @author fu.yuanming
 * @date 2021-07-15
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl {

    private final UserMapper userMapper;

    public User selectUserById(long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public User selectUserByUsername(String username) {
        User user = userMapper.selectUserByUsername(username);
        if (user == null) {
            log.error("用户名【{}】不存在", username);
            return null;
        }
        return user;
    }

}
