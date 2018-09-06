/**
 * 
 */
package com.company.app.web.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.app.commons.exceptions.ServicioException;
import com.company.app.services.inter.MailServicio;

/**
 * @author david
 *
 */
@Controller
@RequestMapping("")
public class CustomerRestController {

	@Autowired
	MailServicio mailServicio;
	
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity getCustomer(@PathVariable("id") Long id) {

		
		try {
			this.mailServicio.enviarMail(new ArrayList(),"davmartb@gmail.com", "Esto es una prueba", "Prueba de correo","davidmartinb@telefonica.net");
		} catch (ServicioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Customer customer = customerDAO.get(id);
//		if (customer == null) {
//			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
//		}

		return new ResponseEntity(id, HttpStatus.OK);
	}
}
