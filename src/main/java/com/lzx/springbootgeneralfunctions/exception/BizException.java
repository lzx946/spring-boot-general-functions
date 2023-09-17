package com.lzx.springbootgeneralfunctions.exception;

import com.lzx.springbootgeneralfunctions.exception.enums.ErrorCode;
import lombok.Data;

/**
 * 自定义业务异常
 *
 * @author Lzx
 * @version 1.0
 * @since 2023/9/17 21:52
 */
@Data
public class BizException extends RuntimeException {

    private final ErrorCode errorCode;

    public BizException() {
        this(ErrorCode.ERROR);
    }

    public BizException(ErrorCode errorCode) {
        super(errorCode.getDesc());
        this.errorCode = errorCode;
    }

    public BizException(String message) {
        this(message, ErrorCode.ERROR);
    }

    public BizException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public BizException(String message, Throwable cause) {
        this(message, cause, ErrorCode.ERROR);
    }

    public BizException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }
}
