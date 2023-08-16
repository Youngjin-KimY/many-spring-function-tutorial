package com.example.jpaproxytutorial;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodStartLoggingAspect extends CheckGererated {

    final static Logger logger =
            LoggerFactory.getLogger(MethodStartLoggingAspect.class);

    public MethodStartLoggingAspect() {
        super("MethodStartLoggingAspect");
    }

    @Before("execution(* *..*Service.*())")
    public void startLog() {
        logger.info("메소드 시작이야");
    }
}
