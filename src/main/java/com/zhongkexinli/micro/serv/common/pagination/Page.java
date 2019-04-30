package com.zhongkexinli.micro.serv.common.pagination;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * 分页对象
 *
 * @param <T>
 *          对象
 */
public class Page<T> implements Serializable {

    private  transient List<T> result = new ArrayList<>();
  
    private transient  T filters;
  
    private int pageSize;
    private int pageNumber;
    private String sortColumns;
    private int totalCount = 0;
  
    private static final String JSONROWS = "rows";
    private static final String JSONPAGE = "page";
  
    public Page(int pageSize) {
      this(pageSize, (T) null);
    }
  
    public Page(T filters) {
      this(5, filters, null);
    }
  
    public Page(int pageSize, T filters) {
      this(pageSize, filters, null);
    }
  
    public Page(int pageSize, String sortColumns) {
      this(pageSize, null, sortColumns);
    }
  
    /**
     * 构造函数
     * 
     * @param pageSize
     *          分页大小
     * @param filters
     *          过滤对象
     * @param sortColumns
     *          排序列
     */
    public Page(int pageSize, T filters, String sortColumns) {
        if (pageNumber == 0) {
            pageNumber = 1;
        }
        this.pageSize = pageSize;
        setFilters(filters);
        setSortColumns(sortColumns);
    }
  
    public T getFilters() {
        return filters;
    }
  
    public void setFilters(T filters) {
        this.filters = filters;
    }
  
    public String getSortColumns() {
        return sortColumns;
    }
  
    public void setSortColumns(String sortColumns) {
        this.sortColumns = sortColumns;
    }
  
    public List<SortInfo> getSortInfos() {
        return Collections.unmodifiableList(SortInfo.parseSortColumns(sortColumns));
    }
  
    public void setResult(List<T> elements) {
        this.result = elements;
    }
  
    public List<T> getResult() {
        return result;
    }
  
    public boolean isFirstPage() {
        return getThisPageNumber() == 1;
    }
  
    public boolean isLastPage() {
        return getThisPageNumber() >= getLastPageNumber();
    }
  
    public boolean isHasNextPage() {
        return getLastPageNumber() > getThisPageNumber();
    }
  
    public boolean isHasPreviousPage() {
        return getThisPageNumber() > 1;
    }
  
    public int getLastPageNumber() {
        return PageUtils.computeLastPageNumber(totalCount, pageSize);
    }
  
    public int getTotalCount() {
        return totalCount;
    }
  
    public int getThisPageFirstElementNumber() {
        return (getThisPageNumber() - 1) * getPageSize() + 1;
    }
  
    public int getThisPageLastElementNumber() {
        int fullPage = getThisPageFirstElementNumber() + getPageSize() - 1;
        return getTotalCount() < fullPage ? getTotalCount() : fullPage;
    }
  
    public int getNextPageNumber() {
        return getThisPageNumber() + 1;
    }
  
    public int getPreviousPageNumber() {
        return getThisPageNumber() - 1;
    }
  
    public int getPageSize() {
        return pageSize;
    }
  
    public int getThisPageNumber() {
        return pageNumber;
    }
    
    public int getPageNumber() {
        return pageNumber;
    }
  
    public List<Integer> getLinkPageNumbers() {
        return PageUtils.generateLinkPageNumbers(getThisPageNumber(), getLastPageNumber(), 10);
    }
  
    public int getFirstResult() {
        return PageUtils.getFirstResult(pageNumber, pageSize);
    }
    
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
  
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
  
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
  
    /**
     *  根据pageSize与totalCount计算总页数, 默认值为-1.
     * @return int 总分页数
     */
    public int getTotalPages() {
        if (totalCount < 0) {
            return -1;
        }
  
        int count = totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            count++;
        }
        return count;
    }
  
    public String toJsonString(List list) {
        return toJsonString(this, list);
    }
  
    /**
     * 分页toString
     * @param page 分页信息
     * @param list 列表信息
     * @return 分页字符串信息
     */
    public String toJsonString(Page page, List list) {
  
        JSONObject all = new JSONObject();
        if (list == null) {
            all.put(JSONROWS, "");
        } else {
            all.put(JSONROWS, JSONObject.toJSONString(list));
        }
    
        all.put(JSONPAGE, page);
        return  all.toString();
    }
  
    /**
     * 获得json字符串
     * 
     * @param object
     *          对象
     * @return 获得json字符串
     */
    public static String toJsonString(Object object) {
        return JSONObject.toJSONString(object);
    }

}
