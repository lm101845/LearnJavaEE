package com.atguigu.spring6.aop.annoaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author liming
 * @Date 2023/9/20 16:36
 **/


@Aspect
@Component
public class LogAspect2 {
    @Before(value = "pointCut()")
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println("Logger-->前置通知，方法名："+methodName+"，参数："+args);
    }


    @After(value = "pointCut()")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println("Logger-->后置通知，方法名："+methodName+"，参数："+args);

    }


    @AfterReturning(value = "execution(* com.atguigu.spring6.aop.annoaop.Calculatorimpl.*(..))",returning = "result")
    public void AfterReturningMethod(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println("Logger-->返回通知，方法名："+methodName+"，参数："+args + ",返回的结果：" + result);
    }


    @AfterThrowing(value = "execution(* com.atguigu.spring6.aop.annoaop.Calculatorimpl.*(..))",throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint,Throwable ex){
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println("Logger-->异常通知，方法名："+methodName+"，参数："+args + "异常信息：" + ex);

    }



    @Around(value = "execution(* com.atguigu.spring6.aop.annoaop.Calculatorimpl.*(..))")
    public Object afterAroundMethod(ProceedingJoinPoint joinPoint){
        Object result = null;
        try {
            System.out.println("环绕通知==目标方法之前执行");
            //调用目标方法
            result = joinPoint.proceed();
            System.out.println("环绕通知==目标方法返回值之后执行");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知==目标方法出现异常执行");
        }finally {
            System.out.println("环绕通知==目标方法执行完毕执行");
        }
        return result;
    }

    //重用切入点表达式
    @Pointcut(value="execution(* com.atguigu.spring6.aop.annoaop.Calculatorimpl.*(..))")
    public void pointCut(){ }
}
