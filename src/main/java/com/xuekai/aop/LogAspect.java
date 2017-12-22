package com.xuekai.aop;

import com.xuekai.utils.JsonTool;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author shixuekai
 * @CreateDate 2017/12/22
 * @Description
 **/
@Aspect
@Component
public class LogAspect {
    private static final Logger LOG= LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(* *(..)) && @annotation(Logrecord)")//根据后边的表达式确定切入点
    public void anyMethod(){

    }

    //在符合切入点的方法前后执行该around
    @Around("anyMethod()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        String targetClassName = proceedingJoinPoint.getTarget().getClass().getSimpleName();
        String methodName = proceedingJoinPoint.getSignature().getName();
        String methodFullName = targetClassName + "." + methodName;
        System.out.println("方法前执行");
        Object result;
        try{
            result=proceedingJoinPoint.proceed();
            LOG.info("记录日志,参数："+getPJPParamsInfo(proceedingJoinPoint));
        }catch (Exception e){
            LOG.error("发生异常，"+e.getMessage());
            throw e;
        }
        System.out.println("方法后执行");

        return result;
    }


    private String getPJPParamsInfo(ProceedingJoinPoint pjp){
        Object[] args = pjp.getArgs();
        return JsonTool.writeToString(args);
    }
}
