package com.szxy.eneity;

import java.util.List;

/**
 * Created by Mr.z on 2018/4/11 0011.
 * 分页实体类
 */
public class PageBean<T> {
    //当前页码
    private Integer pageNow;
    //每页显示数量
    private Integer pageSize;
    //总页数
    private Integer pageCount;
    //总条目
    private Integer rows;
    //查询到的数据
    private List<T> list;

    public PageBean() {
    }

    public PageBean(Integer pageNow, Integer pageSize, Integer pageCount, Integer rows, List<T> list) {
        super();
        this.pageNow = pageNow;
        this.pageSize = pageSize;
        this.pageCount = pageCount;
        this.rows = rows;
        this.list = list;
    }

    public Integer getPageNow() {
        return pageNow;
    }

    public void setPageNow(Integer pageNow) {
        this.pageNow = pageNow;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PageBean [pageNow=");
        builder.append(pageNow);
        builder.append(", pageSize=");
        builder.append(pageSize);
        builder.append(", pageCount=");
        builder.append(pageCount);
        builder.append(", rows=");
        builder.append(rows);
        builder.append(", list=");
        builder.append(list);
        builder.append("]");
        return builder.toString();
    }

}

