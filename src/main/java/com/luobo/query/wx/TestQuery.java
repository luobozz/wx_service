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
public class TestQuery {
    @NotEmpty
    private String atchInstNo;
    @NotEmpty
    private String bsnNo;
    @NotEmpty
    private String empeNo;
    @NotEmpty
    private String srvIP;
    @NotEmpty
    private String wndwNo;
    @NotEmpty
    private String url;
}
