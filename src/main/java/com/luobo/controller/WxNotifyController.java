package com.luobo.controller;

import com.luobo.exception.CustomException;
import com.luobo.query.wx.WxNotifyPortalQuery;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author chenlingyu
 */
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/wx/notify")
public class WxNotifyController {
    private WxMpService wxJavaService;
    private final WxMpService wxMpService;
    @GetMapping(value="portal",produces = "text/plain;charset=utf-8")
    public String getPortal(@Valid WxNotifyPortalQuery query){
        log.info("\n接收到来自微信服务器的认证消息：[{}, {}, {}, {}]", query.getSignature(),
                query.getTimestamp(), query.getNonce(), query.getEchostr());
        if (!wxJavaService.switchover(query.getAppId())) {
            throw new CustomException(String.format("未找到对应appid=[%s]的配置，请核实！", query.getAppId()));
        }

        if (wxJavaService.checkSignature(query.getTimestamp(), query.getNonce(), query.getSignature())) {
            return query.getEchostr();
        }

        return "非法请求";
    }
}
