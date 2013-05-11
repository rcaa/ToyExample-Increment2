package ufpe.br.feature;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import ufpe.br.util.Util;

@Aspect
public class QuoteDynamicDriverAtAspectJ {
	
	@Around("adviceexecution() && within(ufpe.br.feature.Quote)")
	public Object adviceexecutionIdiom(JoinPoint thisJoinPoint, ProceedingJoinPoint pjp) throws Throwable{
		Object ret = null;
		if (Driver.isActivated("quote")){
			ret = pjp.proceed();
		}
		else {
			ret = Util.proceedAroundCallAtAspectJ(thisJoinPoint);
		}
		return ret;
	}
}