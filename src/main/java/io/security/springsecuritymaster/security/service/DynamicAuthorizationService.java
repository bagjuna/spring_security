package io.security.springsecuritymaster.security.service;

import java.util.Map;

import io.security.springsecuritymaster.security.mapper.UrlRoleMapper;

public class DynamicAuthorizationService {
	private final UrlRoleMapper delegate;

	public DynamicAuthorizationService(UrlRoleMapper delegate) {
		this.delegate = delegate;
	}


	public Map<String, String> getUrlRoleMappings() {
		return delegate.getUrlRoleMappings();
	}


}
