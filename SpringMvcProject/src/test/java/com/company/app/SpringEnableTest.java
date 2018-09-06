/*
$Author:  $
$Date: 2016/05/25 14:51:23 $
$Revision: 1.1 $
$State: Exp $
*/      
package com.company.app;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringEnableTest extends TestCase {

	protected static Log log = LogFactory.getLog(SpringEnableTest.class);
	  
	private static ApplicationContext ctx = null;

	public static ApplicationContext getApplicationContext(){
		//Se evalúa si ya ha sido inicializado el contexto
		if(ctx==null){			
			ctx =  new ClassPathXmlApplicationContext(new String[]{
					"/applicationContext.xml"});
		}
		return ctx;
	}
	
	public void testInicializar(){}
}
