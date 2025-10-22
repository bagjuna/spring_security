package io.security.springsecuritymaster.admin.service;

import java.util.List;

import io.security.springsecuritymaster.domain.entity.Role;

public interface RoleService {
    Role getRole(long id);
    List<Role> getRoles();
    List<Role> getRolesWithoutExpression();

    void createRole(Role role);

    void deleteRole(long id);
}
