package in.ineuron.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionManagement {

	@Pointcut("execution(public * in.ineuron.dao.EmployeeDao.*())")
	public void p1() {
	}

	@Around("p1()")
	public void aroundAdvice(ProceedingJoinPoint jp) {

		System.out.println("Before Transaction");
		
		try {
			Object object = jp.proceed();
			System.out.println("DATA IS :: "+object);
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		System.out.println("After Transaction");

	}

}


