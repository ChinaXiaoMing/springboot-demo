package com.opencode.common;

import java.util.List;
import lombok.Data;

/**
 * 通用分页信息结果类
 *
 * @author xiaoming
 * @since 2020-03-21 13:10:10
 **/
@Data
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
        return new PageResult<>(total, dataList);
    }
}
