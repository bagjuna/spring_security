package io.security.springsecuritymaster.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.security.springsecuritymaster.domain.entity.RoleHierarchy;

public interface RoleHierarchyRepository extends JpaRepository<RoleHierarchy, Long> {
}
