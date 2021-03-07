package com.zhongkexinli.micro.serv.common.msg;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 *通用报表数据接口 builder
 * PO对象
 */
@ApiModel(value = "*通用报表数据接口 构建")
@SuppressWarnings("all")
public class CommonReportDataResponseBuilder {

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

    public CommonReportDataResponseBuilder  code(String code) {
        this.code = code;
        return this;
    }
    
    public CommonReportDataResponseBuilder  msg( String msg) {
        this.msg = msg;
        return this;
    }
    
    public CommonReportDataResponseBuilder  count(Long count) {
        this.count = count;
        return this;
    }
    
    public CommonReportDataResponseBuilder  headers(List headers) {
        this.headers = headers;
        return this;
    }
    
    public CommonReportDataResponseBuilder  data( List data) {
        this.data = data;
        return this;
    }
    
    public CommonReportDataResponse  builder() {
        CommonReportDataResponse commonReportDataResponse = new  CommonReportDataResponse();
        commonReportDataResponse.setCode(code);
        commonReportDataResponse.setMsg(msg);
        commonReportDataResponse.setCount(count);
        commonReportDataResponse.setHeaders(headers);
        commonReportDataResponse.setData(data);
        return commonReportDataResponse;
    }
    
}
