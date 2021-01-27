
package com.zhongkexinli.micro.serv.common.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * REST API接口统一响应接口实体builer
 *
 *使用demo:
 * <pre>
 * RestApiResult2 builder = new RestApiResultBuilder()
 *     .respCode(1)
 *     .respData("testData")
 *     .respMsg("success")
 *     .build();
 * </pre></p>
 *
 *
 */
@ApiModel(value = "REST API接口统一响应接口实体")
public class RestApiResultBuilder<T>  {

    @ApiModelProperty(value = "respCode : 返回代码，1表示成功，其它的都有对应问题")
  private int respCode = 1;

    @ApiModelProperty(value = "respMsg : 如果code!=1,错误信息")
  private String respMsg = "成功！";

    @ApiModelProperty(value = "数据编码")
  private String dataCode;

    @ApiModelProperty(value = "返回数据")
  private transient T respData;
    
    @ApiModelProperty(value = "返回消息")
    private String msg;
    
    @ApiModelProperty(value = "返回参数")
    private Object  arguments;
  
    /**
     * 空构造
     */
    public RestApiResultBuilder(){
      //空构造
    }
    
    /**
     * 新增链式构造
     */
    public static RestApiResultBuilder builder() {
        return new RestApiResultBuilder();
    }
  
   /**
   * 链式调用
   * @param respCode 相应码
   * @return 实体对象 RestAPIResult2
   */
    public RestApiResultBuilder respCode(int respCode) {
        this.respCode = respCode;
        return this;
    }
  
    /**
     *  链式调用
     * @param respData 返回数据
     * @return 实体对象 RestAPIResult2
     */
      public RestApiResultBuilder respData(T respData) {
          this.respData = respData;
          return this;
      }
     
      /**
       * 链式调用
       * @param msg 请求消息
       * @param arguments 参数列表，多个参数以,分割，支持数组
       * @return 实体对象 RestAPIResult2
       */
      public RestApiResultBuilder respMsg(String msg,Object... arguments) {
          this.msg = msg;
          this.arguments = arguments;
          return this;
      }
      
      /**
       * 链式调用
       * @param msg 请求消息
       * @param arguments 参数列表，多个参数以,分割，支持数组
       * @return 实体对象 RestAPIResult2
       */
      public RestApiResultBuilder respMsg(String msg) {
          return respMsg(msg,"");
      }
      
    
    public RestApiResult2 build() {
      RestApiResult2 restApiResult2 = new RestApiResult2();
      restApiResult2.respCode(respCode)
                  .respData(respData)
                  .respMsg(msg, arguments);
      return restApiResult2;
    }


}
