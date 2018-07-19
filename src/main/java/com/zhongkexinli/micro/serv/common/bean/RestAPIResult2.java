
package com.zhongkexinli.micro.serv.common.bean;

import java.io.Serializable;

import com.zhongkexinli.micro.serv.common.constant.CommonConstants;

import io.swagger.annotations.ApiModelProperty;

/**
 * RestAPIResult2 <br/>
 * Function: REST API接口统一响应接口实体. <br/>
 * 
 */
//@ApiModel(value = "REST API接口统一响应接口实体")
public class RestAPIResult2<T> implements Serializable {

	/**
	 * serialVersionUID:
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "respCode : 返回代码，1表示成功，其它的都有对应问题")
    private int respCode = 1;

    @ApiModelProperty(value = "respMsg : 如果code!=1,错误信息")
    private String respMsg="成功！";
    
    @ApiModelProperty(value = "数据编码")
    private String dataCode;
    
    @ApiModelProperty(value = "token")
    private String token;//token
    
    private Object respData;
    private String LoginFlag;//判断是否跳登录
    
    private String loginNo;
    public String getLoginNo() {
		return loginNo;
	}

	public void setLoginNo(String loginNo) {
		this.loginNo = loginNo;
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

	public RestAPIResult2(String errorMsg){
		this.respMsg = errorMsg;
		this.respCode =CommonConstants.ERROR;
	}
	
	public RestAPIResult2(){
	}
 
	public void success(T object){
		this.respCode = CommonConstants.SUCCESS;
		this.respMsg = CommonConstants.SUCCESS_MSG;
	}
	public void error(){
		this.respCode = CommonConstants.ERROR;
		this.respMsg = CommonConstants.FAIL;
	}
	public void error(String message){
		this.respCode = CommonConstants.ERROR;
		this.respMsg = message;
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

	public Object getRespData() {
		return respData;
	}

	public void setRespData(Object respData) {
		this.respData = respData;
	}

	public String getLoginFlag() {
		return LoginFlag;
	}

	public void setLoginFlag(String loginFlag) {
		LoginFlag = loginFlag;
	}
	
}
