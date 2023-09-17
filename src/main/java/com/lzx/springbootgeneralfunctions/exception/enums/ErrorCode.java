package com.lzx.springbootgeneralfunctions.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 错误状态码
 *
 * @author Lzx
 * @version 1.0
 * @since 2023/9/17 21:53
 */
@AllArgsConstructor
public enum ErrorCode {

    UNAUTHORIZED("Unauthorized", "未登录"),
    ERROR("error", "服务器异常"),
    ;

    @Getter
    private final String code;

    @Getter
    private final String desc;
}
