package io.security.springsecuritymaster.security.mapper;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.security.springsecuritymaster.admin.repository.ResourcesRepository;
import io.security.springsecuritymaster.domain.entity.Resources;

public class PersistentUrlRoleMapper implements UrlRoleMapper {

	private final LinkedHashMap<String, String> urlRoleMappings = new LinkedHashMap<>();
	private final ResourcesRepository resourcesRepository;

	public PersistentUrlRoleMapper(ResourcesRepository resourcesRepository) {
		this.resourcesRepository = resourcesRepository;
	}

	@Override
	public Map<String, String> getUrlRoleMappings() {
		urlRoleMappings.clear();
		List<Resources> resourcesList = resourcesRepository.findAllResources();
		resourcesList.forEach(re -> {
			re.getRoleSet().forEach(e ->{
				urlRoleMappings.put(re.getResourceName(), e.getRoleName());
			});
		});
		return urlRoleMappings;
	}



}
