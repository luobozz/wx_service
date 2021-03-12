package com.luobo.query;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * BaseQuery class
 *
 * @author chenlingyu
 * @date 2020/6/3 13:37
 */
@Data
@AllArgsConstructor
public class BaseQuery {
    public BaseQuery(){
        this.pageNo=1;
        this.maxResults=500;
    }
    public Integer pageNo;
    public Integer maxResults;
    private Integer start;

    public void passPage(Integer pageIndex,Integer pageSize){
        int maxPageSize=5000;
        if(pageIndex>0&&pageSize>0&&pageSize<=maxPageSize){
            this.pageNo=pageIndex;
            this.maxResults=pageSize;
        }
    }


    //设定默认值 必须为不分页状态即pageIndex=-1
//    private void setDefaultPageSize(int pageSize) {
//        if(this.getPageIndex()<0){
//            this.setPageSize(pageSize);
//        }
//    }
}
