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
    if (params.get("limit") != null) {
      this.limit = Integer.parseInt(params.get("limit").toString());
    }
    if (params.get("pageNum") != null) {
      this.pageNum = Integer.parseInt(params.get("pageNum").toString());
    }
    if (params.get("pageSize") != null) {
      this.pageSize = Integer.parseInt(params.get("pageSize").toString());
    }
    this.remove("page");
    this.remove("limit");
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
  
}