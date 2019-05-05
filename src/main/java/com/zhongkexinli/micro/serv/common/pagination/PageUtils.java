package com.zhongkexinli.micro.serv.common.pagination;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 分页工具类
 *
 */
public class PageUtils {

    private PageUtils() {
      
    }
    
    /**
     * 获得第一次分页结果
     * 
     * @param pageNumber
     *          分页编号
     * @param pageSize
     *          每页记录数
     * @return int 获得第一次分页结果
     */
    public static int getFirstResult(int pageNumber, int pageSize) {
        if (pageSize <= 0) {
            throw new IllegalArgumentException("[pageSize] must great than zero");
        }
        return (pageNumber - 1) * pageSize;
    }
  
    /**
     * 分页列表
     * 
     * @param currentPageNumber
     *          当前页
     * @param lastPageNumber
     *          最大分页数
     * @param count
     *          总记录数
     * @return LIST 分页列表
     */
    public static List<Integer> generateLinkPageNumbers(int currentPageNumber, int lastPageNumber, int count) {
        int avg = count / 2;
    
        int startPageNumber = currentPageNumber - avg;
        if (startPageNumber <= 0) {
            startPageNumber = 1;
        }
    
        int endPageNumber = startPageNumber + count - 1;
        if (endPageNumber > lastPageNumber) {
            endPageNumber = lastPageNumber;
        }
    
        if (endPageNumber - startPageNumber < count) {
            startPageNumber = endPageNumber - count;
            if (startPageNumber <= 0) {
                startPageNumber = 1;
            }
        }
    
        List<Integer> result = new ArrayList<>();
        for (int i = startPageNumber; i <= endPageNumber; i++) {
            result.add(i);
        }
        return result;
    }
  
    /**
     * 计算最大分页数
     * 
     * @param totalElements
     *          总数
     * @param pageSize
     *          每页记录数
     * @return int 计算最大分页数
     */
    public static int computeLastPageNumber(int totalElements, int pageSize) {
        int result = totalElements % pageSize == 0 ? totalElements / pageSize : totalElements / pageSize + 1;
        if (result <= 1) {
            result = 1;
        }
        return result;
    }
  
    /**
     * 计算分几页
     * 
     * @param pageNumber
     *          分页编号
     * @param pageSize
     *          每页记录数
     * @param totalElements
     *          总数
     * @return int 计算分几页
     */
    public static int computePageNumber(int pageNumber, int pageSize, int totalElements) {
        if (pageNumber <= 1) {
            return 1;
        }
        // last page
        if (Integer.MAX_VALUE == pageNumber || pageNumber > computeLastPageNumber(totalElements, pageSize)) { 
            return computeLastPageNumber(totalElements, pageSize);
        }
        return pageNumber;
    }
}
