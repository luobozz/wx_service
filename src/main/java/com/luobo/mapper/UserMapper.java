package com.luobo.mapper;

import com.luobo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * WxUserMapper interface
 *
 * @author chenlingyu
 * @date 2020/6/9 15:25
 */
@Mapper
public interface UserMapper {
    List<User> selectList();
}
