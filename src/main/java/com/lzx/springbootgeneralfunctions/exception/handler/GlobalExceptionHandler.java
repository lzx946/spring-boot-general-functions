package com.lzx.springbootgeneralfunctions.exception.handler;

import com.lzx.springbootgeneralfunctions.exception.BizException;
import com.lzx.springbootgeneralfunctions.res.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常统一处理器
 *
 * @author Lzx
 * @version 1.0
 * @since 2023/9/18 00:13
 */
@Slf4j
@Component
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 自定义异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public ResponseDTO<?> defaultExceptionHandler(BizException e) {
        return ResponseDTO.fail(e.getErrorCode().getCode(), e.getMessage());
    }

    /**
     * 请求方式不支持（Request method not supported）
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public ResponseDTO<Void> httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException e) {
        return ResponseDTO.fail(e.getMessage());
    }

    /**
     * 请求类型不支持（Content type not supported）
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = HttpMediaTypeNotSupportedException.class)
    @ResponseBody
    public ResponseDTO<Void> httpMediaTypeNotSupportedExceptionHandler(HttpMediaTypeNotSupportedException e) {
        return ResponseDTO.fail(e.getMessage());
    }

    /**
     * query必传参数缺失异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    @ResponseBody
    public ResponseDTO<Void> missingServletRequestParameterExceptionHandler(MissingServletRequestParameterException e) {
        return ResponseDTO.fail(String.format("%s[%s]参数必传", e.getParameterName(), e.getParameterType()));
    }

    /**
     * {@code @RequestBody} 参数校验不通过时抛出的异常处理
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseDTO<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        if (CollectionUtils.isEmpty(bindingResult.getFieldErrors())) {
            return ResponseDTO.fail("参数校验错误");
        } else {
            return ResponseDTO.fail(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseDTO<?> exceptionHandler(Exception e) {
        // 打印日志, 将异常一起打进去
        log.error(e.getMessage(), e);

        return ResponseDTO.fail("请求失败！");
    }
}
