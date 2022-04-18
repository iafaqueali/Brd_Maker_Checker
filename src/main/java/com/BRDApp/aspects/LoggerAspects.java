package com.BRDApp.aspects;



import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


@Aspect
@Component
@EnableAspectJAutoProxy
public class LoggerAspects {
    private Logger mylogger = Logger.getLogger(getClass().getName());
    @Pointcut(value = "execution(* com.BRDApp.dao*.*(..))")
    private void forgetter() {
    }


    @Before("forgetter()")
    public void pojocall(JoinPoint point) {
        mylogger.info(point.getSignature().getName() + " called...");

    }

    // for all controller method
    @Before(value = "execution(* com.BRDApp.controller.*.*(..))")
    public void forsetter(JoinPoint point) {
        mylogger.info(point.getSignature().getName() + " called...");

    }

    // for all service method
    @Before(value = "execution(* com.BRDApp.service.*.*(..))")
    public void forservice(JoinPoint point) {
        mylogger.info(point.getSignature().getName() + " called...");

    }


//    //    private Logger log = java.util.logging.Logger.getLogger(LoggerAspects.class);
//    //  upar wala not work
//    private Logger log = Logger.getLogger(getClass().getName());
//    @Pointcut(value = "execution(* com.BRDApp.dao.*())")
//    private void forgetter() {
//    }
//
//
//    @Before("forgetter()")
//    public void pojocall(JoinPoint point) {
//        log.info(point.getSignature().getName() + " called...");
//
//    }
//
//    // for all controller method
//    @Before(value = "execution(* com.BRDApp.controller.*(..))")
//    public void forsetter(JoinPoint point) {
//        log.info(point.getSignature().getName() + " called...");
//
//    }
//
//    // for all service method
//    @Before(value = "execution(* com.BRDApp.service.*())")
//    public void forservice(JoinPoint point) {
//        log.info(point.getSignature().getName() + " called...");
//
//    }
}
