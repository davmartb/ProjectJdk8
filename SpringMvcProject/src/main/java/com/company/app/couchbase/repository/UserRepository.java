/**
 * 
 */
package com.company.app.couchbase.repository;

import java.util.List;

import org.springframework.data.couchbase.core.query.View;
import org.springframework.data.repository.CrudRepository;

import com.couchbase.client.java.cluster.User;

/**
 * @author davidPort
 *
 */
public interface UserRepository extends CrudRepository<User,String> {
	
	/**
     * Additional custom finder method, backed by an auto-generated
     * N1QL query.
     */
    List<User> findByDomain(String domain);

    /**
     * Additional custom finder method, backed by a View that indexes
     * the names.
     */
    @View(designDocument = "user", viewName = "byName")
    List<User> findByName(String name);



}
