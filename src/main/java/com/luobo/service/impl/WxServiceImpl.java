package com.luobo.service.impl;


import com.luobo.entity.User;
import com.luobo.mapper.UserMapper;
import com.luobo.service.WxService;

import com.luobo.utils.RedisHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * OrderServiceImpl
 *
 * @author chenlingyu
 */
@Service
public class WxServiceImpl implements WxService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisHelper redisHelper;

    @Override
    public List<User> users() {
        redisHelper.set("TEST","123");
        return userMapper.selectList();
    }

}