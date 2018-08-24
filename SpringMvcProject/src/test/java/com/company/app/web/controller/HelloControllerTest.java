/**
 * 
 */
package com.company.app.web.controller;


import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
/**
 * @author davidPort
 *
 */
public class HelloControllerTest {

	@Test
    public void testHandleRequestView() throws Exception{		
        HelloController controller = new HelloController();
        ModelAndView modelAndView = controller.handleRequest(null, null);		
        assertEquals("hello.jsp", modelAndView.getViewName());
    }

}
