/**
 * 
 */
package com.company.app.couchbase.services;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.company.app.couchbase.entity.Book;
import com.company.app.couchbase.repository.BookRepo;

/**
 * @author davidPort
 *
 */
public class ApplicationTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new ClassPathResource("spring-couchbase-integration.xml").getPath());

         BookRepo bookRepo = context.getBean(BookRepo.class);

          

         Book book = new Book();

         book.setBookId(123);;

         book.setIsbnNumber(2133443554);

         book.setName("Kane And Abel by XYZ");

         bookRepo.save(book);

          

         Book anotherBook = new Book();

         anotherBook.setBookId(456);;

         anotherBook.setIsbnNumber(2133443554);

         anotherBook.setName("The Prodigal Daughter");

         bookRepo.save(anotherBook);

          

         Book retreivedBook = bookRepo.findOne(new Long(123));
         

          

         System.out.println(retreivedBook);

          

         bookRepo.delete(456l);

          

         context.close();

   }


	}

