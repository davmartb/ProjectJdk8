/**
 * 
 */
package com.company.app.couchbase.repository;

import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import com.company.app.couchbase.entity.Book;

/**
 * @author davidPort
 *
 */
@Repository
public interface BookRepo extends CouchbaseRepository<Book, Long> {

}
