package io.security.springsecuritymaster.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.security.springsecuritymaster.domain.entity.Account;

public interface UserManagementRepository extends JpaRepository<Account, Long> { }
