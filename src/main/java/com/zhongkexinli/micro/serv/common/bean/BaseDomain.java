package com.zhongkexinli.micro.serv.common.bean;

import java.io.Serializable;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * @ClassName: BaseDomain
 * @Description: domain父类，放置公用属性
 */

public class BaseDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    /** easyui的datagrid向后台传递参数使用的model */

    /** 开始记录 */
    private int               start            = 0;
    /** 当前页 */
    private int               page             = 1;
    private int               pageNum          = 1;
    /** 每页显示记录数 */
    private int               rows             = 10;
    private int               pageSize         = 10;
    /** 排序字段名 */
    private String            sort;
    /** 排序(asc,desc) */
    private String            order;
    /** 标记下拉框中被选中的选项 */
    private String            flag             = "";
    /** 错误信息 */
    private String            errMsg           = "";
    /** 机构编号 */
    private String            instid           = "";
    /* for procedure response */
    /** 应答代码 */
    private String            retCode          = "";
    /**
     * 行号
     */
    private Integer           rowNo            = 0;
    /* 是否分页 */
    private boolean           isPaging         = true;
    /* 当前登录所属分站ID */
    private Integer           currCid;

    /* 财务报表专用字段 */
    private String            reportDate;

    private String  cids;

    public String getCids() {
        return cids;
    }

    public void setCids(String cids) {
        this.cids = cids;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
        this.start = (this.page - 1) * this.rows;
        this.pageNum = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
        this.start = (this.page - 1) * this.rows;
        this.pageSize = rows;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        if (sort == null) return null;
        if (order == null || (!order.equals("desc") && !order.equals("asc"))) {
            return "asc";
        }
        return order;
    }

    public void setOrder(String order) {
        if (order == null || (!order.equals("desc") && !order.equals("asc"))) {
            this.order = "asc";
        } else {
            this.order = order;
        }
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getInstid() {
        return instid;
    }

    public void setInstid(String instid) {
        this.instid = instid;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        setRows(pageSize);
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        setPage(pageNum);
    }

    public Integer getRowNo() {
        return rowNo;
    }

    public void setRowNo(Integer rowNo) {
        this.rowNo = rowNo;
    }

    public boolean isPaging() {
        return isPaging;
    }

    public void setPaging(boolean isPaging) {
        this.isPaging = isPaging;
    }

    public Integer getCurrCid() {
        return currCid;
    }

    public void setCurrCid(Integer currCid) {
        this.currCid = currCid;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    @Override
    public String toString() {

        Map<Object, Object> json = (Map<Object, Object>) JSON.toJSON(this);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Object, Object> entry : json.entrySet()) {
            if (entry.getValue() != null && !entry.getValue().equals("") && !entry.getKey().equals("pageNum")
                && !entry.getKey().equals("page") && !entry.getKey().equals("paging")
                && !entry.getKey().equals("pageSize") && !entry.getKey().equals("start")
                && !entry.getKey().equals("rowNo") && !entry.getKey().equals("rows")) sb.append(entry.getKey()).append(entry.getValue());
        }
        return sb.toString();

    }
}
