
package com.zhongkexinli.micro.serv.common.bean;

import java.io.Serializable;

import org.slf4j.helpers.MessageFormatter;

import com.zhongkexinli.micro.serv.common.constant.CommonConstants;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * REST API接口统一响应接口实体
 * 
 * @author admin
 *
 */
@ApiModel(value = "REST API接口统一响应接口实体")
@SuppressWarnings("serial")
public class RestApiResult2<T> implements Serializable {

    @ApiModelProperty(value = "respCode : 返回代码，1表示成功，其它的都有对应问题")
    private int respCode = 1;

    @ApiModelProperty(value = "respMsg : 如果code!=1,错误信息")
    private String respMsg = "成功！";

    @ApiModelProperty(value = "数据编码")
    private String dataCode;

    @ApiModelProperty(value = "token")
    private String token;// token

    @ApiModelProperty(value = "返回数据")
    private  T respData;

    @ApiModelProperty(value = "判断是否跳登录")
    private String loginFlag;
    
    @ApiModelProperty(value = "请求跟踪Id")
    private String traceId;

    /**
     * 空构造
     */
    public RestApiResult2() {
        // 空构造
    }
    
    /**
     * 新增链式构造
     * @return
     */
    public static RestApiResultBuilder builder() {
        return new RestApiResultBuilder();
    }

    public RestApiResult2(String errorMsg) {
        this.respMsg = errorMsg;
        this.respCode = CommonConstants.ERROR;
    }

    public int getRespCode() {
        return respCode;
    }

    public void setRespCode(int respCode) {
        this.respCode = respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }

    /**
     * 链式调用
     * 
     * @param respCode
     *            相应码
     * @return 实体对象 RestAPIResult2
     */
    public RestApiResult2 respCode(int respCode) {
        this.respCode = respCode;
        return this;
    }

    /**
     * 链式调用
     * 
     * @param msg
     *            请求消息
     * @param arguments
     *            参数列表，多个参数以,分割，支持数组
     * @return 实体对象 RestAPIResult2
     */
    public RestApiResult2 respMsg(String msg, Object... arguments) {
        String formattedMessage;
        if (arguments != null) {
            formattedMessage = MessageFormatter.arrayFormat(msg, arguments).getMessage();
        } else {
            formattedMessage = msg;
        }

        this.respMsg = formattedMessage;
        return this;
    }

    /**
     * 链式调用
     * 
     * @param msg
     *            请求消息
     * @return 实体对象 RestAPIResult2
     */
    public RestApiResult2 respMsg(String msg) {
        return respMsg(msg, null);
    }

    /**
     * 链式调用
     * 
     * @param respData
     *            返回数据
     * @return 实体对象 RestAPIResult2
     */
    public RestApiResult2 respData(T respData) {
        this.respData = respData;
        return this;
    }
    
    /**
     * 链式调用
     * 
     * @param traceId
     *            返回数据
     * @return 实体对象 RestAPIResult2
     */
    public RestApiResult2 traceId(String traceId) {
        this.traceId = traceId;
        return this;
    }

    public String getDataCode() {
        return dataCode;
    }

    public void setDataCode(String dataCode) {
        this.dataCode = dataCode;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public T getRespData() {
        return respData;
    }

    public void setRespData(T respData) {
        this.respData = respData;
    }

    public String getLoginFlag() {
        return loginFlag;
    }

    public void setLoginFlag(String loginFlag) {
        this.loginFlag = loginFlag;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

}
