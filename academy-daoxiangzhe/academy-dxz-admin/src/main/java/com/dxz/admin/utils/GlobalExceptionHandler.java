package com.dxz.admin.utils;

import com.dxz.admin.result.CodeInfo;
import com.dxz.admin.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.Set;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // 表单格式参数校验
    @ExceptionHandler(value = BindException.class)
    public Result errorHandler(BindException ex) {
        BindingResult result = ex.getBindingResult();
        StringBuilder errorMsg = new StringBuilder();
        for (ObjectError error : result.getAllErrors()) {
            errorMsg.append(error.getDefaultMessage()).append(",");
        }
        errorMsg.delete(errorMsg.length() - 1, errorMsg.length());
        logger.error("BindException异常：{}" ,errorMsg.toString());
        return new Result(CodeInfo.PARAM_VALID_WRONG.getCode(), errorMsg.toString());
    }

    /**
     * 方法参数校验
     */
    @ExceptionHandler(value=ValidationException.class)
    public Result exceptionHandler(ValidationException e){
        String msg = new String();
        if(e instanceof ConstraintViolationException){
            ConstraintViolationException exs = (ConstraintViolationException) e;
            Set<ConstraintViolation<?>> violations = exs.getConstraintViolations();
            for (ConstraintViolation<?> item : violations) {
                msg = item.getMessage();
            }
        }
        logger.error("ValidationException异常：{}" ,ResponseEntity.badRequest().body(msg).getBody());
        return new Result(CodeInfo.PARAM_VALID_WRONG.getCode(), ResponseEntity.badRequest().body(msg).getBody());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result errorHandler(MethodArgumentNotValidException ex) {
        StringBuilder errorMsg = new StringBuilder();
        BindingResult re = ex.getBindingResult();
        for (ObjectError error : re.getAllErrors()) {
            errorMsg.append(error.getDefaultMessage()).append(",");
        }
        errorMsg.delete(errorMsg.length() - 1, errorMsg.length());
        logger.error("MethodArgumentNotValidException异常：{}" ,errorMsg.toString());
        return new Result(CodeInfo.PARAM_VALID_WRONG.getCode(), errorMsg.toString());
    }

    /**
     * 异常捕捉
     */
    @ExceptionHandler(value=Exception.class)
    public Result exceptionHandler(Exception e){
        logger.error("Exception异常：{}" ,e.getMessage());
        return new Result(CodeInfo.SOMETHING_WRONG.getCode(), CodeInfo.SOMETHING_WRONG.getMsg());
    }
}
