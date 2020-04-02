package com.opencode.common;

import java.util.List;

/**
 * @Description 通用分页信息结果类
 * @Author xiaoming
 * @Date 2020-03-21 13:10:10
 * @Version 1.0
 **/
public class PageResult<T> {
    //数据总数
    private long total;
    //待分页数据列表
    private List<T> dataList;

    public PageResult(long total, List<T> dataList) {
        this.total = total;
        this.dataList = dataList;
    }

    /**
     * 获取分页信息
     * @param total 数据总数
     * @param dataList 数据列表
     * @return PageResult<T>
     */
    public static <T> PageResult<T> getPageInfo(long total, List<T> dataList) {
        return new PageResult<T>(total, dataList);
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getData() {
        return dataList;
    }

    public void setData(List<T> dataList) {
        this.dataList = dataList;
    }
}
