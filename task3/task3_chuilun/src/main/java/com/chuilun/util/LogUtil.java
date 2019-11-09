package com.chuilun.util;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LogUtil {

    private static final Logger logger = Logger.getLogger("LogUtil");

    // 定义了一个名为 ‘selectAll’ 的切入点
    // 该切入点将与 com.chuilun.controller.service 包下的类中可用的每一个方法相匹配
    // controller后的“ * ”分别代表所有类、类下的所有方法，“（..）”代表方法内的任意参数
    @Pointcut("execution(* com.chuilun.controller.*.*(..))")
    private void selectAll(){}

    // 环绕通知 = 前置 + 目标方法执行 + 后置通知
/*    @Around("selectAll()")
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
    }*/

    // 在一个方法执行之后，只有在方法成功完成时，才能执行通知
    @AfterReturning(pointcut = "selectAll()", returning="retVal")
    public void afterReturningAdvice(JoinPoint jp, Object retVal){
        //getTarget() 获得被织入增强处理的目标对象，类路径
        String className = jp.getTarget().getClass().getName();
        // 获取方法名
        String methodName=jp.getSignature().getName();
        logger.info("运行方法名：" + methodName + "，类路径：" + className);
        logger.info("基于注解，方法成功返回:" + retVal.toString() );
    }

    // 在一个方法执行之前，执行通知
    @Before("selectAll()")
    public void beforeAdvice(){
        logger.info("基于注解，准备执行方法");
    }

    // 在一个方法执行之后，不考虑其结果，执行通知
    @After("selectAll()")
    public void afterAdvice(){
        logger.info("基于注解，方法结束");
    }

    // 在一个方法执行之后，只有在方法成功完成时，才能执行通知
/*    @AfterReturning(pointcut = "selectAll()", returning="retVal")
    public void afterReturningAdvice(Object retVal){
        logger.info("基于注解，方法成功返回:" + retVal.toString() );
    }*/

    // 在一个方法执行之后，只有在方法退出抛出异常时，才能执行通知
    @AfterThrowing(pointcut = "selectAll()", throwing = "ex")
    public void AfterThrowingAdvice(IllegalArgumentException ex){
        logger.info("基于注解，方法异常为: " + ex.toString());
    }
}
