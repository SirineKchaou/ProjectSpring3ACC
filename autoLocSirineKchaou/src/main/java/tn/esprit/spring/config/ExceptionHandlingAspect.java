package tn.esprit.spring.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ExceptionHandlingAspect {
    @AfterThrowing(
            pointcut = "execution(* tn.esprit.spring.service..*(..))",
            throwing = "exception"
    )
    public void handleException(JoinPoint joinPoint, Throwable exception) {


        String methodName = joinPoint.getSignature().getName();


        log.error("Une exception a été détectée !");
        log.error("Méthode concernée : {}", methodName);
        log.error("Type d'exception : {}", exception.getClass().getName());
        log.error("Message d'erreur : {}", exception.getMessage());
    }
}
