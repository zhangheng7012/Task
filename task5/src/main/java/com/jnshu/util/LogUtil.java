package com.jnshu.util;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogUtil {

    private static final Logger logger = Logger.getLogger("LogUtil");

    // 定义了一个名为 ‘selectAll’ 的切入点
    // 该切入点将与 com.chuilun.controller.service 包下的类中可用的每一个方法相匹配
    // controller后的“ * ”分别代表所有类、类下的所有方法，“（..）”代表方法内的任意参数
    @Pointcut("execution(* com.jnshu.controller.*.*(..))")
    private void selectAll(){}

    // 环绕通知 = 前置 + 目标方法执行 + 后置通知
    @Around("selectAll()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        // 获取方法名
        String methodName=joinPoint.getSignature().getName();
        //getTarget() 获得被织入增强处理的目标对象，类路径
        String className = joinPoint.getTarget().getClass().getName();
        logger.info("环绕前增强=====方法名：" + methodName + "，类路径：" + className);
        // ProceedingJoinPoint 执行 proceed 方法的作用是让目标方法执行，返回结果
        Object obj  = joinPoint.proceed();
        logger.info("环绕后增强=====");
        logger.info("方法成功返回：" + obj.toString());
        return obj;
    }

}
