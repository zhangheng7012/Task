package com.chuilun.util;

import org.apache.log4j.Logger;

public class LogXmlUtil {

    private static final Logger logger = Logger.getLogger("LogXmlUtil");

    // 在一个方法执行之前，执行通知
    public void beforeAdvice(){
        logger.info("准备执行方法");
    }

    // 在一个方法执行之后，不考虑其结果，执行通知
    public void afterAdvice(){
        logger.info("方法结束");
    }

    // 在一个方法执行之后，只有在方法成功完成时，才能执行通知
    public void afterReturningAdvice(Object retVal){
        logger.info("方法成功返回:" + retVal.toString() );
    }

    // 在一个方法执行之后，只有在方法退出抛出异常时，才能执行通知
    public void AfterThrowingAdvice(IllegalArgumentException ex){
        logger.info("方法异常为: " + ex.toString());
    }
}
