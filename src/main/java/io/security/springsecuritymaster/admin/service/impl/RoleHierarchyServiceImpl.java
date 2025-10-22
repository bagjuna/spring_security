package io.security.springsecuritymaster.admin.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.security.springsecuritymaster.admin.repository.RoleHierarchyRepository;
import io.security.springsecuritymaster.admin.service.RoleHierarchyService;
import io.security.springsecuritymaster.domain.entity.RoleHierarchy;

@Service
public class RoleHierarchyServiceImpl implements RoleHierarchyService {
    private RoleHierarchyRepository roleHierarchyRepository;

    @Autowired
    private void setRoleHierarchyServiceImpl(RoleHierarchyRepository roleHierarchyRepository) {
        this.roleHierarchyRepository = roleHierarchyRepository;
    }

    @Override
    public String findAllHierarchy() {
        List<RoleHierarchy> roleHierarchies = roleHierarchyRepository.findAll();

        Iterator<RoleHierarchy> itr = roleHierarchies.iterator();
        StringBuilder hieranchyRole = new StringBuilder();

        while (itr.hasNext()) {
            RoleHierarchy roleHierarchy = itr.next();
            if (roleHierarchy.getParent() != null) {
                hieranchyRole.append(roleHierarchy.getParent().getRoleName());
                hieranchyRole.append(" > ");
                hieranchyRole.append(roleHierarchy.getRoleName());
                hieranchyRole.append("\n");
            }
        }
        return hieranchyRole.toString();
    }


}
