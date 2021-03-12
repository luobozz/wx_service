package com.luobo.controller;

import org.springframework.web.bind.annotation.*;

/**
 * OrderController
 *
 * @author chenlingyu
 */
@RestController
@RequestMapping("/wx/api")
public class WxApiController {

    /**
     * TODO test上线前检查一下消除
     */
    @GetMapping("test")
    public void test() {

    }
}