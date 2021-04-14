package com.luobo.controller;
import com.luobo.query.wx.TestQuery;
import com.luobo.utils.HttpXmlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * OrderController
 *
 * @author chenlingyu
 */
@RestController
@RequestMapping("/")
public class TestApiController {

    @Autowired
    private HttpXmlUtil httpXmlUtil;

    /**
     * TODO test上线前检查一下消除
     */
    @GetMapping("/test")
    public String test(@Valid TestQuery query) throws Exception {
        httpXmlUtil.toxml(query);
        return "ok";
    }
}