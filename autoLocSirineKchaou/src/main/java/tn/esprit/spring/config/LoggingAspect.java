package tn.esprit.spring.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LoggingAspect {


    @Before("execution(* tn.esprit.spring.service..*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {

        Object[] parameters = joinPoint.getArgs();

        log.info("La méthode appelée : " + joinPoint.getSignature().getName() + " : ");

        log.info("Les Paramètres : {}", Arrays.toString(parameters));
    }

    @AfterReturning("execution(* tn.esprit.spring.service..*(..))")
    public void logMethodExit2(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        log.info("La méthode 2 terminée : " + name);


    }

    @After("execution(* tn.esprit.spring.service..*(..))")
    public void logMethodExit1(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        log.info("La méthode terminée : " + name);


    }
}
