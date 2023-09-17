package com.lzx.springbootgeneralfunctions.res;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * API统一返回格式
 *
 * @author Lzx
 * @version 1.0
 * @since 2023/9/18 00:21
 */
@Data
@AllArgsConstructor
public class ResponseDTO<T> {

    private static final String SUCCESS_CODE = "0";
    private static final String FAIL_CODE = "9999";

    /**
     * 响应状态码
     */
    private String code;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;

    public static <T> ResponseDTO<T> success(T data) {
        return response(SUCCESS_CODE, "SUCCESS", data);
    }

    public static <T> ResponseDTO<T> success(String message, T data) {
        return response(SUCCESS_CODE, message, data);
    }

    public static <T> ResponseDTO<T> fail(String message) {
        return response(FAIL_CODE, message, null);
    }

    public static <T> ResponseDTO<T> fail(String code, String message) {
        return response(code, message, null);
    }

    public static <T> ResponseDTO<T> response(String code, String message, T data) {
        return new ResponseDTO<>(code, message, data);
    }
}
