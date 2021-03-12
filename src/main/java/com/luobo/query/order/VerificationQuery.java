package com.luobo.query.order;

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
public class VerificationQuery {

    @Min(1)
    @NotEmpty
    private Integer orderId;
    @Min(1)
    @NotEmpty
    private Integer accountId;

    private Integer terminal;
    @Min(1)
    @Max(2)
    @NotEmpty
    private Integer type;
    private String verStr;
}
