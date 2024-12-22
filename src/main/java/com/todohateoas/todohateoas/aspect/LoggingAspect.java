package com.todohateoas.todohateoas.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;
@Log4j2
@Component
@Aspect
public class LoggingAspect {
@Before("execution(* com.todohateoas.todohateoas..*.*(..))")
public void logging(JoinPoint point){
log.info("O método: " + point.getSignature().toShortString() + " está prestes a ser chamado");
}
}
