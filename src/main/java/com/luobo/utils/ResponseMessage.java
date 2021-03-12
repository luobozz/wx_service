package com.luobo.utils;


import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * RequestMessage class
 *
 * @author chenlingyu
 * @date 2020/4/14 9:56
 */
@Data
@NoArgsConstructor
public class ResponseMessage {


    private int code = 0;
    private long total = 0;
    private String message = "";
    public Timestamp timestamp=TimeStampHelper.getNow();
    private List<?> data = new ArrayList<>();

    public ResponseMessage data(Object data) {
        if(data!=null){
            List dataList = new ArrayList<>();
            dataList.add(data);
            this.dataList(dataList);
        }
        return this;
    }

    public ResponseMessage dataList(List<?> dataList) {
        this.data = dataList;
        this.total = dataList.size();
        boolean isEmptyList=dataList == null || dataList.size() <= 0;
        if (isEmptyList) {
            this.setCode(404);
            this.setMessage("没有数据");
        }
        return this;
    }

    public ResponseMessage total(long total) {
        if (this.data.size() > 0) {
            this.total = total;
        }
        return this;
    }

    public ResponseMessage customMsg(String message) {
        if(message!=""){
            this.message=message;
        }
        return this;
    }

    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }
}
