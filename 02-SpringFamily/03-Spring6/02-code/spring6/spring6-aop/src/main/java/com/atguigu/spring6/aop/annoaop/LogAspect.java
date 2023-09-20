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


@Aspect   ////切面类
@Component  //表示在IOC容器中进行管理
public class LogAspect {
    //设置切入点和通知类型
    //切入点表达式: execution(访问修饰符 增强方法返回类型 增强方法所在类全路径.方法名称(方法参数))
    //通知类型：
    // 前置  @Before(value="切入点表达式配置切入点")
    //@Before(value = "execution(* com.atguigu.spring6.aop.annoaop.*.*(..))")
    @Before(value = "execution(public int com.atguigu.spring6.aop.annoaop.Calculatorimpl.*(..))")
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println("Logger-->前置通知，方法名："+methodName+"，参数："+args);
    }

    // 后置  @After
    @After(value = "execution(* com.atguigu.spring6.aop.annoaop.Calculatorimpl.*(..))")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println("Logger-->后置通知，方法名："+methodName+"，参数："+args);

    }

    // 返回  @AfterReturning
    @AfterReturning(value = "execution(* com.atguigu.spring6.aop.annoaop.Calculatorimpl.*(..))",returning = "result")
    public void AfterReturningMethod(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println("Logger-->返回通知，方法名："+methodName+"，参数："+args + ",返回的结果：" + result);
    }

    // 异常  @AfterThrowing   获取到目标方法的异常信息
    //  目标方法出现了异常,这个通知才会执行
    @AfterThrowing(value = "execution(* com.atguigu.spring6.aop.annoaop.Calculatorimpl.*(..))",throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint,Throwable ex){
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println("Logger-->异常通知，方法名："+methodName+"，参数："+args + "异常信息：" + ex);

    }


    // 环绕  @Around
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
}
