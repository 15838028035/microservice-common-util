package com.zhongkexinli.micro.serv.common.pagination;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 查询参数
 */
public class Query extends LinkedHashMap<String, Object> {
  private static final long serialVersionUID = 1L;
//当前页码
  private Integer page = 1;
//每页条数
  private Integer limit = 10;
 
  private Integer pageNum = 1;
    
  private int               pageSize         = 10;
  
  private String limitParam = "limit";

  /**
   * 不带分页查询条件
   */
  public Query() {
    
  }
  
  /**
   * 分页构造
   * @param params 分页参数
   */
  public Query(Map<String, Object> params) { 
    this.putAll(params);
    //分页参数
    if (params.get("page") != null) {
      this.page = Integer.parseInt(params.get("page").toString());
    }
    if (params.get(limitParam) != null) {
      this.limit = Integer.parseInt(params.get(limitParam).toString());
    }
    if (params.get("pageNum") != null) {
      this.pageNum = Integer.parseInt(params.get("pageNum").toString());
    }
    if (params.get("pageSize") != null) {
      this.pageSize = Integer.parseInt(params.get("pageSize").toString());
    }
    this.remove("page");
    this.remove(limitParam);
  }
  
  /**
   * 构造链式查询
   * @param key  key
   * @param value value
   * @return
   */
  public Query putFilter(String key, Object value) {
      this.put(key, value);
      return this;
  }
  
  public int getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }
  public int getLimit() {
    return limit;
  }

  public void setLimit(int limit) {
    this.limit = limit;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public Integer getPageNum() {
    return pageNum;
  }

  public void setPageNum(Integer pageNum) {
    this.pageNum = pageNum;
  }

  public void setLimit(Integer limit) {
    this.limit = limit;
  }
}