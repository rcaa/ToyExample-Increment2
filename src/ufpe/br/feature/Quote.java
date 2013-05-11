package ufpe.br.feature;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Quote {
	
	@Pointcut("execution(* ufpe.br.base.BaseClass.validateText(..)) && args(string)")
	public void quote(String string){}
	
	@Pointcut("execution(* ufpe.br.base.BaseClass.validateTextOnly(..)) && args(string)")
	public void quote2(String string){}
	
	@Pointcut("execution(* ufpe.br.base.BaseClass.validateCharacterOnly(..)) && args(c)")
	public void quote3(char c){}
	
	// quote
	
	@Around("quote(string)")
	public Object aroundQuote1(String string, ProceedingJoinPoint pjp) throws Throwable{
		return pjp.proceed(new Object[]{"\"" + string + "\""});
	}
	
	@Around("quote(string)")
	public Object aroundQuote11(String string, ProceedingJoinPoint pjp) throws Throwable{
		return pjp.proceed(new Object[]{"$" + string + "$"});
	}
	
	@Around("quote(string)")
	public Object aroundQuote12(String string, ProceedingJoinPoint pjp) throws Throwable{
		return pjp.proceed(new Object[]{"#" + string + "#"});
	}
	
	// quote 2
	
	@Around("quote2(string)")
	public Object aroundQuote2(String string, ProceedingJoinPoint pjp) throws Throwable{
		return pjp.proceed(new Object[]{"\"" + string + "\""});
	}
	
	@Around("quote2(string)")
	public Object aroundQuote21(String string, ProceedingJoinPoint pjp) throws Throwable{
		return pjp.proceed(new Object[]{"$" + string + "$"});
	}
	
	@Around("quote2(string)")
	public Object aroundQuote22(String string, ProceedingJoinPoint pjp) throws Throwable{
		return pjp.proceed(new Object[]{"#" + string + "#"});
	}
	
	// quote
	
	@Before("quote(string)")
	public void before1(String string){
		System.out.println("advising code <before advice> <quote>");
	}
	
	@AfterReturning("quote(string)")
	public void afterReturning1(String string){
		System.out.println("advising code <after returning advice> <quote>");
	}
	
	@After("quote(string)")
	public void after1(String string){
		System.out.println("advising code <after advice> <quote>");
	}

	
	// quote 2
	
	@Before("quote2(string)")
	public void before2(String string){
		System.out.println("advising code <before advice> <quote>");
	}
	
	@AfterReturning("quote2(string)")
	public void afterReturning2(String string){
		System.out.println("advising code <after returning advice> <quote>");
	}
	
	@After("quote2(string)")
	public void after2(String string){
		System.out.println("advising code <after advice> <quote>");
	}
	
	// quote 3
	
	@Before("quote3(c)")
	public void before3(char c){
		System.out.println("advising code <before advice> <quote>");
	}
	
	@AfterReturning("quote3(c)")
	public void afterReturning3(char c){
		System.out.println("advising code <after returning advice> <quote>");
	}
	
	@After("quote3(c)")
	public void after3(char c){
		System.out.println("advising code <after advice> <quote>");
	}
}