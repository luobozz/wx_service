package com.luobo.controller;

import com.luobo.log.Log;
import org.springframework.web.bind.annotation.*;

/**
 * OrderController
 *
 * @author chenlingyu
 */
@RestController
@RequestMapping("api")
public class WxController {

    /**
     * TODO test上线前检查一下消除
     */
    @GetMapping("test")
    public void test() {
        Log.info("测试");
    }


}