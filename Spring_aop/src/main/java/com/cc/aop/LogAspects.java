package com.cc.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @ClassName LogAspects
 * @Author chenchen
 * @Date 2020/2/9 22:18
 * @Version 1.0
 **/
@Aspect//标志此类是一个切面类
public class LogAspects {
    //抽取公共的切入点表达式
    //1、本类引用
    @Pointcut("execution(public int com.cc.aop.MathCalculator.div(int,int))")
    public void pointCut(){

    }
    //@Before在目标方法之前切入；切入点表达式（指定在那个方法切入）
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName()+"运行了参数列表是：{"+ Arrays.toString(args)+"}");
    }
    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+"除法结束。。。。");

    }
    //JoinPoint一定要出现在参数表的第一位
    @AfterReturning(value="pointCut()",returning="result")
    public void logReturn(JoinPoint joinPoint,Object result){
        System.out.println(joinPoint.getSignature().getName()+"正常返回。。。。运行结果：{"+result+"}");
    }
    @AfterThrowing(value="pointCut()",throwing = "exception")
    public void logException(JoinPoint joinPoint,Exception exception){
        System.out.println(joinPoint.getSignature().getName()+"异常。。。。异常信息：{"+exception+"}");
    }
}
