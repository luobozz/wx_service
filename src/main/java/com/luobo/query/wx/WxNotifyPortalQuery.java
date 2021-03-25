package com.luobo.query.wx;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * @author zhangjiadong
 * @date 2020/6/6
 */
@Data
@AllArgsConstructor
public class WxNotifyPortalQuery {
//    @NotEmpty
    private String appId;
//    @NotEmpty
    private String signature;
//    @NotEmpty
    private String timestamp;
//    @NotEmpty
    private String nonce;
//    @NotEmpty
    private String echostr;
}
