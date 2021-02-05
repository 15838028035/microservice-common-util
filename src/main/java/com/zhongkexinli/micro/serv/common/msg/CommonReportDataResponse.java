package com.zhongkexinli.micro.serv.common.msg;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 *通用报表数据接口
 * PO对象
 */
@ApiModel(value = "*通用报表数据接口")
public class CommonReportDataResponse {
    @ApiModelProperty(value = "编码")
    private String code;
    @ApiModelProperty(value = "消息")
    private String msg;
    @ApiModelProperty(value = "总数")
    private Long count;
    
    @ApiModelProperty(value = "相应Header ")
    private List headers = new ArrayList();
    
    @ApiModelProperty(value = "返回数据信息 ")
    private List data = new ArrayList();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List getHeaders() {
        return headers;
    }

    public void setHeaders(List headers) {
        this.headers = headers;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
    
}
