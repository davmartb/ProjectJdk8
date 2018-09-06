/**
 * 
 */
package com.company.app.couchbase.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

/**
 * @author davidPort
 *
 */
@Configuration
@EnableCouchbaseRepositories
public class Config extends AbstractCouchbaseConfiguration {

	/* (non-Javadoc)
	 * @see org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration#getBootstrapHosts()
	 */
	@Override
	protected List<String> getBootstrapHosts() {
		return Arrays.asList("host1", "host2");
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration#getBucketName()
	 */
	@Override
	protected String getBucketName() {
		return "default";
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration#getBucketPassword()
	 */
	@Override
	protected String getBucketPassword() {
		return "";
	}

}
