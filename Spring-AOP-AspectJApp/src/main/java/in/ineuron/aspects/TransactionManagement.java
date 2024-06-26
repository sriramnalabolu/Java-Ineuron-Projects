package in.ineuron.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionManagement {

	// Syntax:: AS RT packageName.ClassName.methodName(parameter)
	@Pointcut("execution(public void in.ineuron.dao.EmployeeDao.saveEmployee())")
	public void saveOperation() {}
	
	@Before("") // JoinPoint
	public void beginTransaction() {
		System.out.println("Transaction begin");
	}

	@After("") // JoinPoint
	public void commitTransaction() {
		System.out.println("Transaction commited...");
	}

}

/*
 * //Syntax:: AS RT packageName.ClassName.methodName(parameter)
 * 
 * @Pointcut("execution(public * in.ineuron.dao.*.deleteEmployee())") public
 * void deleteOperation() {}
 * 
 * @Pointcut("saveOperation() || deleteOperation()") public void operation() {}
 */