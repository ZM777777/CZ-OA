package com.gx.logger;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.gx.inf.InfoFool;
import com.gx.inf.JdType;
/**
 * 监控类
 * @author win10
 *
 */
@Aspect
public class ServiceLogger{
	public static String[] ArrLi = new String[]{JdType.SELECT};
	/**
	 * 权限监控 - 用户
	 * @param point
	 * @return
	 * @throws Throwable
	 */
	@Around("execution(* com.gx.serviceImpl.QxService.*(..))")
	public Object aroundLogger(ProceedingJoinPoint point) throws Throwable{
		Method method = reFlex(point);
		InfoFool If = method.getAnnotation(InfoFool.class);
		System.out.println(If.isEnable());
		boolean isOk = false;//标识权限
		if(ArrLi != null && ArrLi.length > 0){
			for(int i = 0; i < ArrLi.length; i++){
				if(ArrLi[i].equals(If.isEnable())){
					isOk = true;
					break;
				}
			}
		}
		if(isOk){
			System.out.println("有权限!");
			return point.proceed();
		}else {
			System.err.println("你没有权限!");
			return "NO";
		}
	}
	/**
	 * 反射方法
	 * @param point
	 * @return
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	private Method reFlex(ProceedingJoinPoint point) throws NoSuchMethodException, SecurityException{
		Object[] args = point.getArgs();
		Class<?>[] argTypes = new Class[point.getArgs().length];
		for (int i = 0; i < args.length; i++) {
			argTypes[i] = args[i].getClass();
		}
		Method method = point.getTarget().getClass()
				.getMethod(point.getSignature().getName(),argTypes);
		return method;
	}
}
