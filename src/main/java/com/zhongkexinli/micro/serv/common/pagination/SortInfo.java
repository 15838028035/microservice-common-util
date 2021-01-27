package com.zhongkexinli.micro.serv.common.pagination;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * 排序
 *
 */
public class SortInfo implements Serializable {

    private static final long serialVersionUID = 6959974032209696722L;

    private String columnName;
    private String sortOrder;

    public SortInfo() {
    }

    /**
     * 构造函数
     * 
     * @param columnName
     *            列名称
     * @param sortOrder
     *            排序方式
     */
    public SortInfo(String columnName, String sortOrder) {
        super();
        this.columnName = columnName;
        this.sortOrder = sortOrder;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * 排序解析
     * 
     * @param sortColumns
     *            排序列
     * @return 列表
     */
    public static List<SortInfo> parseSortColumns(String sortColumns) {
        if (sortColumns == null) {
            return Collections.<SortInfo>emptyList();
        }

        List<SortInfo> results = new ArrayList();
        String[] sortSegments = sortColumns.trim().split(",");
        for (int i = 0; i < sortSegments.length; i++) {
            String sortSegment = sortSegments[i];
            String[] array = sortSegment.split("\\s+");

            SortInfo sortInfo = new SortInfo();
            sortInfo.setColumnName(array[0]);
            sortInfo.setSortOrder(array.length == 2 ? array[1] : null);
            results.add(sortInfo);
        }
        return results;
    }

    public String toString() {
        return columnName + (sortOrder == null ? "" : " " + sortOrder);
    }
}
