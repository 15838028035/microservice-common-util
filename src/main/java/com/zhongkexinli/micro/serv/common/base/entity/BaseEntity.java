package com.zhongkexinli.micro.serv.common.base.entity;

import java.io.Serializable;

import com.zhongkexinli.micro.serv.common.util.StringUtil;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * 基础实体
 *
 */
@SuppressWarnings("serial")
@ApiModel(value = "基础实体")
public class BaseEntity implements Serializable {

  /**
   * 创建人 create_by
   */
  @ApiModelProperty(value = "创建人")
  private Integer createBy;

  /**
   * 创建人 create_By_UName
   */
  @ApiModelProperty(value = "创建人")
  private String createByUname;

  /**
   * 创建日期 create_date
   */
  @ApiModelProperty(value = "创建日期 ")
  private String createDate;

  /**
   * 创建时间查询
   */
  @ApiModelProperty(value = "创建时间查询")
  private String createDateBegin;

  /**
   * 创建时间查询
   */
  @ApiModelProperty(value = "创建时间查询")
  private String createDateEnd;
  
  /**
   * 更新人 update_by
   */
  @ApiModelProperty(value = "更新人")
  private Integer updateBy;

  /**
   * 更新人 update_By_Uname
   */
  @ApiModelProperty(value = "更新人")
  private String updateByUname;

  /**
   * 更新日期 update_date
   */
  @ApiModelProperty(value = "更新日期 ")
  private String updateDate;

  /**
   * 更新日期 查询
   */
  @ApiModelProperty(value = "更新日期 查询")
  private String updateDatebegin;

  /**
   * 更新日期 查询
   */
  @ApiModelProperty(value = "更新日期 查询")
  private String updateDateEnd;

  /**
   * 是否有效 enable_flag
   */
  @ApiModelProperty(value = "是否有效")
  private String enableFlag = "";

  /**
   * 加载状态 lock_status
   */
  @ApiModelProperty(value = "加锁状态")
  private String lockStatus = "";

  /**
   * 应用ID app_id
   */
  @ApiModelProperty(value = "应用ID")
  private String appId;

  /**
   * 排序字段
   */
  @ApiModelProperty(value = "排序字段")
  private String sidx;

  /**
   * 排序方式
   */
  @ApiModelProperty(value = "排序方式")
  private String sord;

  /**
   * 状态
   */
  @ApiModelProperty(value = "状态")
  private String status;

  /**
   * 查询条件
   */
  @ApiModelProperty(value = "查询条件")
  private String conditionWhere;

  /**
   * 从写toString方法
   */
  public String toString() {
    return StringUtil.printAllMethodAndAttrInfo(this);
  }

  public Integer getCreateBy() {
    return createBy;
  }

  public void setCreateBy(Integer createBy) {
    this.createBy = createBy;
  }

  public String getCreateDate() {
    return createDate;
  }

  public void setCreateDate(String createDate) {
    this.createDate = createDate;
  }

  public Integer getUpdateBy() {
    return updateBy;
  }

  public void setUpdateBy(Integer updateBy) {
    this.updateBy = updateBy;
  }

  public String getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(String updateDate) {
    this.updateDate = updateDate;
  }

  public String getEnableFlag() {
    return enableFlag;
  }

  public void setEnableFlag(String enableFlag) {
    this.enableFlag = enableFlag;
  }

  public String getLockStatus() {
    return lockStatus;
  }

  public void setLockStatus(String lockStatus) {
    this.lockStatus = lockStatus;
  }

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public String getSidx() {
    return sidx;
  }

  public void setSidx(String sidx) {
    this.sidx = sidx;
  }

  public String getSord() {
    return sord;
  }

  public void setSord(String sord) {
    this.sord = sord;
  }

  public String getCreateDateBegin() {
    return createDateBegin;
  }

  public void setCreateDateBegin(String createDateBegin) {
    this.createDateBegin = createDateBegin;
  }

  public String getCreateDateEnd() {
    return createDateEnd;
  }

  public void setCreateDateEnd(String createDateEnd) {
    this.createDateEnd = createDateEnd;
  }

  public String getUpdateDatebegin() {
    return updateDatebegin;
  }

  public void setUpdateDatebegin(String updateDatebegin) {
    this.updateDatebegin = updateDatebegin;
  }

  public String getUpdateDateEnd() {
    return updateDateEnd;
  }

  public void setUpdateDateEnd(String updateDateEnd) {
    this.updateDateEnd = updateDateEnd;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getCreateByUname() {
    return createByUname;
  }

  public void setCreateByUname(String createByUname) {
    this.createByUname = createByUname;
  }

  public String getUpdateByUname() {
    return updateByUname;
  }

  public void setUpdateByUname(String updateByUname) {
    this.updateByUname = updateByUname;
  }

  public String getConditionWhere() {
    return conditionWhere;
  }

  public void setConditionWhere(String conditionWhere) {
    this.conditionWhere = conditionWhere;
  }
}
