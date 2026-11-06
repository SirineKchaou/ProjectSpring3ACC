package tn.esprit.spring.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class PerformanceAspect {

    @Around("execution(* tn.esprit.spring.service..*(..))")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint)
            throws Throwable {

        String methodName = joinPoint.getSignature().getName();

        long start = System.currentTimeMillis();


        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();

        long executionTime = end - start;

        log.info("Méthode : {}", methodName);
        log.info("Temps d'exécution : {} ms", executionTime);

        if (executionTime > 1000) {
            log.warn("ATTENTION : La méthode {} est lente !", methodName);
        }

        return result;
    }
}
