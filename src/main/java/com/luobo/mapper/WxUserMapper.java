package com.luobo.mapper;

import com.luobo.entity.WxUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * WxUserMapper interface
 *
 * @author chenlingyu
 * @date 2020/6/9 15:25
 */
@Mapper
public interface WxUserMapper {
    /**
     * @param userId
     * @return
     */
    WxUser selectOneByMainUserId(Integer userId);

    String selectOneUserOpnid(Integer userId);
}
