package com.kingsoft.servicea.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kingsoft.servicea.entity.User;
import com.kingsoft.servicea.mapper.UserMapper;
import com.kingsoft.servicea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Sheledon
 * @date 2022/4/11
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User loginVerify(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",user.getUsername());
        queryWrapper.eq("password",user.getPassword());
        return userMapper.selectOne(queryWrapper);
    }
}
