/*
$Author: A161496 $
$Date: 2008/08/20 09:41:28 $
$Revision: 1.3 $
$State: Exp $
*/      
package com.company.app.web.controller;

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