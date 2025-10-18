package io.security.springsecuritymaster.users.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.security.springsecuritymaster.domain.entity.Account;
import io.security.springsecuritymaster.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	@Transactional
	public void createUser(Account account) {
		userRepository.save(account);
	}



}
