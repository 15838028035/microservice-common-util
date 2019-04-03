
package com.zhongkexinli.micro.serv.common.bean;

import java.io.Serializable;
import java.text.MessageFormat;

import org.slf4j.helpers.MessageFormatter;

import com.zhongkexinli.micro.serv.common.constant.CommonConstants;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *  REST API接口统一响应接口实体
 * @author admin
 *
 * @param <T> 实体PO
 */
@ApiModel(value = "REST API接口统一响应接口实体")
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

  @ApiModelProperty(value = "返回数据")
  private transient Object respData;
  
  @ApiModelProperty(value = "判断是否跳登录")
  private String loginFlag;

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
	  this.respData = object;
	}
	
	/**
	 * 新增格式化函数
	 * @param msg
	 * @param formatParam
	 * @param object
	 */
	public void messageFormat(String msg, String formatParam,T object){
    this.respCode = CommonConstants.SUCCESS;
    String respMsg = MessageFormat.format(msg, formatParam);
    this.respMsg = respMsg;
    this.respData = object;
  }
	
	/**
   * 新增格式化函数
   * @param msg
   * @param formatParam
   * @param object
   */
  public void messageFormat(String msg, String formatParam){
     messageFormat( msg,  formatParam,null);
  }
	
	public void error(){
		this.respCode = CommonConstants.ERROR;
		this.respMsg = CommonConstants.FAIL;
	}
	public void error(String message){
		this.respCode = CommonConstants.ERROR;
		this.respMsg = message;
	}

	/**
 * 	链式调用
 * @param respCode
 * @return
 */
  public RestAPIResult2 respCode(int respCode){
    this.respCode = respCode;
    this.respMsg = respMsg;
    return this;
  }
    
    /**
     *  链式调用
     * @param respCode
     * @return
     */
      public RestAPIResult2 respMsg(String msg,Object... arguments){
        String formattedMessage = msg;
        if (arguments != null) {
          formattedMessage = MessageFormatter.arrayFormat(msg, arguments).getMessage();
      } else {
          formattedMessage = msg;
      }
        
        this.respMsg = formattedMessage;
        return this;
     }
    
    /**
     *  链式调用
     * @param respCode
     * @return
     */
      public RestAPIResult2 respMsg(String msg){
        return respMsg(msg, null);
     }
      
    /**
     *  链式调用
     * @param respCode
     * @return
     */
      public RestAPIResult2 respData(Object respData){
        this.respData = respData;
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

	public Object getRespData() {
		return respData;
	}

	public void setRespData(Object respData) {
		this.respData = respData;
	}

	public String getLoginFlag() {
		return loginFlag;
	}

	public void setLoginFlag(String loginFlag) {
		this.loginFlag = loginFlag;
	}
	
}
