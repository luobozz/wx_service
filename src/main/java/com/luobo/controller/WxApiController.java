package com.luobo.controller;

import com.luobo.service.WxService;
import com.luobo.utils.CodeMessageHandle;
import com.luobo.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * OrderController
 *
 * @author chenlingyu
 */
@RestController
@RequestMapping("/wx/api")
public class WxApiController {

    @Autowired
    private CodeMessageHandle codeMessageHandle;
    @Autowired
    private WxService wxService;

    /**
     * TODO test上线前检查一下消除
     */
    @GetMapping("test")
    public ResponseMessage test() {
        return codeMessageHandle.code(200).dataList(wxService.users());
    }
}