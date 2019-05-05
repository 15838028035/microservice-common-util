package com.zhongkexinli.micro.serv.common.pagination;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhongkexinli.micro.serv.common.util.StringUtil;

/**
 * 
 * 分页工具类
 *
 */
public class PageTool {
    public static final String JSONPAGE = "page";
    public static final String JSONROWS = "rows";
  
    /**
     * 转换
     * 
     * @param str
     *          字符串
     * @return 字符串
     */
    public static String convert(String str) {
        if (StringUtil.isBlank(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
    
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
    
            if ((c >= 'A') && (c <= 'Z')) {
                if (i == 0) {
                    sb.append(Character.toLowerCase(c));
                } else {
                    sb.append("_" + Character.toLowerCase(c));
                }
            } else {
                sb.append(c);
            }
        }
    
        return sb.toString();
    }
    
    /**
     * layui分页
     * @param page 分页对象
     * @return 分页字符串信息
     */
    public static String pageToJsonLayui(Page page) {
        Map<String, Object> mapResult = new HashMap<>();
        mapResult.put("pageNumber", page.getPageNumber());
        mapResult.put("pageSize", page.getPageSize());
        mapResult.put("page", page.getPageNumber());
        mapResult.put("totalPage", page.getTotalPages());
        mapResult.put("total", page.getTotalCount());
        mapResult.put("rows", page.getResult());
        return Page.toJsonString(mapResult);
    }
    
    public static String toJsonString(Object object) {
        return Page.toJsonString(object);
    }
  
    public String toJsonString(Page page, List list) {
        return page.toJsonString(list);
    }
  
    public static String getJsonpage() {
        return JSONPAGE;
    }
  
    public static String getJsonrows() {
        return JSONROWS;
    }

}
