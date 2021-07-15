package com.opencode.common;

import lombok.Data;

/**
 * 通用分页信息结果类
 *
 * @author xiaoming
 * @since 2020-03-21 13:10:10
 **/
@Data
public class PageResult<T> {
    /**
     * 数据总数
     */
    private long total;
    /**
     * 数据
     */
    private T data;

    public PageResult(long total, T data) {
        this.total = total;
        this.data = data;
    }

    /**
     * 获取分页信息
     * @param total 数据总数
     * @param data 数据列表
     * @return PageResult<T>
     */
    public static <T> PageResult<T> getPageInfo(long total, T data) {
        return new PageResult<>(total, data);
    }
}
