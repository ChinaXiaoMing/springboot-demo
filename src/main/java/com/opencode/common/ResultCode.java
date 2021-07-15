package com.opencode.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 响应结果枚举类
 *
 * @author fu.yuanming
 * @date 2021-07-14
 */
@Getter
@AllArgsConstructor
public enum ResultCode {
    /**
     * 成功
     */
    SUCCESS(200, "操作成功"),
    /**
     * 失败的
     */
    FAILED(500, "操作失败"),
    /**
     * 参数错误
     */
    PARAM_ERROR(400, "请求参数错误"),
    /**
     * 未经授权的
     */
    UNAUTHORIZED(401, "暂未登录或登录已过期"),
    /**
     * 被禁止的
     */
    FORBIDDEN(403, "没有相关权限"),
    /**
     * 没有找到
     */
    NOT_FOUND(404, "没有找到请求资源");

    /**
     * 状态码
     */
    private final int code;

    /**
     * 提示消息
     */
    private final String message;

}
