package com.luobo.service.impl;


import com.luobo.entity.User;
import com.luobo.mapper.UserMapper;
import com.luobo.service.WxService;

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

    @Override
    public List<User> users() {
        return userMapper.selectList();
    }

}