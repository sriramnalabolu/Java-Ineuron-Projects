package in.ineuron.aspects;
import org.springframework.stereotype.Component;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
@Component
public class TransactionManagement {

	// Syntax:: AS RT packageName.ClassName.methodName(parameter)
	@Pointcut("execution(public * in.ineuron.dao.*.saveEmployee())")
	public void saveOperation() {}
	
	//Syntax:: AS RT packageName.ClassName.methodName(parameter)
	@Pointcut("execution(public * in.ineuron.dao.*.deleteEmployee())") 
	public void deleteOperation() {}
	
	@Pointcut("saveOperation() || deleteOperation()") 
	public void operation() {}
	
	@Before("operation()") // JoinPoint
	public void beginTransaction() {
		System.out.println("Transaction begin");
	}

	@After("operation()") // JoinPoint
	public void commitTransaction() {
		System.out.println("Transaction commited...");
	}
}  
