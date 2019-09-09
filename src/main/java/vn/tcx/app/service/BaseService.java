package vn.tcx.app.service;

import org.springframework.cache.CacheManager;

import vn.tcx.app.config.ApplicationProperties;

abstract class BaseService {

	protected final ApplicationProperties properties;
	protected final CacheManager cacheManager;
	
	public BaseService(ApplicationProperties properties, CacheManager cacheManager) {
		this.properties = properties;
		this.cacheManager = cacheManager;
	}
}
