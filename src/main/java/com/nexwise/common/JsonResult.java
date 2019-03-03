package com.nexwise.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.List;

public class JsonResult extends HashMap<String, Object> {

    static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 封装分页参数
     * @param list 分页数据列表
     * @param total 记录总数
     * @return
     */
    public static String getPageData(List<?> list, long total) throws JsonProcessingException {
        JsonResult jsonResult = new JsonResult();
        jsonResult.put("list", list);
        jsonResult.put("total", total);
        return objectMapper.writeValueAsString(jsonResult);
    }

}
