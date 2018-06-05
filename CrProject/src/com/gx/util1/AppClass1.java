package com.gx.util1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 调用APP的XML
 * @author win10
 *
 */
public class AppClass1 {
	/**
	 * applicationContext工具方法
	 * @param name
	 * @return
	 */
	public static Object getBanst(String name){
		ApplicationContext apc = new ClassPathXmlApplicationContext("applicationContext.xml");
		Object ctx = apc.getBean(name);
		return ctx;
	}
}
